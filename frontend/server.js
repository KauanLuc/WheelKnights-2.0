const express = require("express");
const axios = require("axios");
const multer = require("multer");
const path = require("path");

const app = express();
const PORT = 3000;

const backendHost = process.env.BACKEND_HOST || "http://backend:8080";

app.set("view engine", "ejs");
app.set("views", "./views");

app.use("/public", express.static(path.join(__dirname, "public")));
app.use("/uploads", express.static(path.join(__dirname, "uploads")));
app.use(express.json());

const storage = multer.diskStorage({
    destination: "uploads/",
    filename: (req, file, cb) => {
        const uniqueSuffix = Date.now() + path.extname(file.originalname);
        cb(null, file.fieldname + "-" + uniqueSuffix);
    }
});
const upload = multer({ storage });

app.get("/", (req, res) => {
    res.render("index");
});

app.get("/dashboard", async (req, res) => {
    try {
        const total = (await axios.get(`${backendHost}/dashboard/total`)).data;
        const collectionValue = (await axios.get(`${backendHost}/dashboard/collection-value`)).data;
        const moreExpensive = (await axios.get(`${backendHost}/dashboard/more-expensive`)).data;
        const cheaper = (await axios.get(`${backendHost}/dashboard/cheaper`)).data;
        const miniaturesByManufacturer = (await axios.get(`${backendHost}/dashboard/miniatures-by-manufacturer`)).data;
        const expensesPerManufacturer = (await axios.get(`${backendHost}/dashboard/expenses-per-manufacturer`)).data;
        const miniaturesByVehicleType = (await axios.get(`${backendHost}/dashboard/miniatures-by-vehicle-type`)).data;
        const expensesPerVehicleType = (await axios.get(`${backendHost}/dashboard/expenses-per-vehicle-type`)).data;

        const cards = [
            { idDiv: "total", content: total, name: "Quantidade de Miniaturas" },
            { idDiv: "collectionValue", content: "R$ " + collectionValue.toFixed(2), name: "Valor Estimado da Coleção" },
            { idDiv: "moreExpensive", content: "R$ " + moreExpensive, name: "Miniatura mais Cara" },
            { idDiv: "cheaper", content: "R$ " + cheaper, name: "Miniatura mais Barata" }
        ];

        const graphs = [
            { caption: "Quantidade de Miniaturas por Marca", content: miniaturesByManufacturer, canvasId: "chartMiniaturesByManufacturer" },
            { caption: "Gastos por Marca (R$)", content: expensesPerManufacturer, canvasId: "chartExpensesPerManufacturer" },
            { caption: "Quantidade de Miniaturas por Tipo de Veículo", content: miniaturesByVehicleType, canvasId: "chartMiniaturesByVehicleType" },
            { caption: "Gastos por Tipo de Veículo (R$)", content: expensesPerVehicleType, canvasId: "chartExpensesPerVehicleType" }
        ];

        res.render("dashboard", { cards, graphs });
    } catch (error) {
        res.status(500).json({ message: "Erro ao carregar o dashboard: " + error.message });
    }
});

app.get("/album", async (req, res) => {
    try {
        const miniatures = (await axios.get(`${backendHost}/miniatures`)).data;
        res.render("album", { miniatures });
    } catch (error) {
        res.status(500).json({ message: "Erro ao carregar álbum de miniaturas: " + error.message });
    }
});

app.post("/miniatures", upload.single("imagePath"), async (req, res) => {
    const { model, manufacturer, theme, vehicleType, purchasePrice } = req.body;
    const imagePath = req.file ? req.file.path : null;

    try {
        await axios.post(`${backendHost}/miniatures`, {
            model, manufacturer, theme, vehicleType, purchasePrice, imagePath
        });
        res.status(201).json({ message: "Miniatura cadastrada com sucesso!" });
    } catch (error) {
        res.status(500).json({ message: "Erro ao tentar cadastrar miniatura: " + error.message });
    }
});

app.listen(PORT, () => {
    console.log(`Servidor rodando na porta ${PORT}`);
});