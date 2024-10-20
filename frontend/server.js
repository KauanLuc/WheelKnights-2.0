const express = require("express");
const axios = require("axios");
const multer = require("multer");
const path = require("path");

const app = express();
const PORT = 3000;

app.set("view engine", "ejs");
app.set("views", "./views");

app.use("/public", express.static(__dirname + "/public"));
app.use('/uploads', express.static(path.join(__dirname, 'uploads')));
app.use(express.json());

const storage = multer.diskStorage({
    destination: "uploads/",
    filename: (req, file, cb) => {
        const uniqueSuffix = Date.now() + path.extname(file.originalname);
        cb(null, file.fieldname + "-" + uniqueSuffix);
    }
});
const upload = multer({storage});

app.get("/", (req, res) => {
    res.render("index");
});

app.get("/dashboard", async (req, res) => {
    try {
        const total = (await axios.get("http://localhost:8080/dashboard/total")).data;
        const collectionValue = (await axios.get("http://localhost:8080/dashboard/collection-value")).data;
        const moreExpensive = (await axios.get("http://localhost:8080/dashboard/more-expensive")).data;
        const cheaper = (await axios.get("http://localhost:8080/dashboard/cheaper")).data;

        const miniaturesByManufacturer = (await axios.get("http://localhost:8080/dashboard/miniatures-by-manufacturer")).data;
        
        const cards = [
            { idDiv: "total", content: total, name: "Quantidade de Miniaturas" },
            { idDiv: "collectionValue", content: "R$ " + collectionValue.toFixed(2), name: "Valor Estimado da Coleção" },
            { idDiv: "moreExpensive", content: "R$ " + moreExpensive, name: "Miniatura mais Cara" },
            { idDiv: "cheaper", content: "R$ " + cheaper, name: "Miniatura mais Barata" }
        ];

        const graphs = [
            { caption: "Quantidade de Miniaturas por Marca", canvasId: "chartMiniaturesByManufacturer" },
            { caption: "Gastos por Marca (R$)", canvasId: "chartExpensesPerManufacturer" },
            { caption: "Quantidade de Miniaturas por Tipo de Veículo", canvasId: "chartMiniaturesByVehicleType" },
            { caption: "Gastos por Tipo de Veículo (R$)", canvasId: "chartExpensesPerVehicleType" }
        ];

        res.render("dashboard", { cards, graphs });
    } catch (error) {
        res.status(500).json({ message: "Erro ao carregar o dashboard: " + error.message });
    }
});

app.get("/album", async (req, res) => {
    try{
        const miniatures = (await axios.get("http://localhost:8080/miniatures")).data;

        res.render("album", { miniatures });
    } catch (error) {
        res.status(500).json({ message: "Erro ao carregar álbum de miniaturas: " + error.message });
    }
});

app.post("/miniatures", upload.single("imagePath"), async (req, res) => {
    const {model, manufacturer, theme, vehicleType, purchasePrice} = req.body;
    const imagePath = req.file ? req.file.path : null;

    try {
        const response = await axios.post("http://localhost:8080/miniatures", {
           model, manufacturer, theme, vehicleType, purchasePrice, imagePath 
        });

        res.status(201).json({message: "Miniatura cadastrada com sucesso!"});
    } catch(error) {
        res.status(500).json({message: "Erro ao tentar cadastrar miniatura."});
    }
});

app.listen(PORT, () => {
    console.log("Servidor rodando na porta " + PORT);
});