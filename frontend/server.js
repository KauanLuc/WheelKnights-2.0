const express = require("express");
const axios = require("axios");
const multer = require("multer");
const path = require("path");

const app = express();
const PORT = 3000;

app.set("view engine", "ejs");
app.set("views", "./views");

app.use("/public", express.static(__dirname + "/public"));
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


app.post("/miniatures", upload.single("imagePath"), async (req, res) => {
    const {model, manufacturer, theme, vehicleType, purchasePrice} = req.body;
    const imagePath = req.file ? req.file.path : null;

    try {
        const response = await axios.post("http://localhost:8080/miniatures", {
           model, manufacturer, theme, vehicleType, purchasePrice, imagePath 
        });

        res.status(201).json({message: "Miniatura cadastrada com sucesso!"});
    } catch(error) {
        res.status(500).json({message: "Erro ai tentar cadastrar miniatura."});
    }
});

app.listen(PORT, () => {
    console.log("Servidor rodando na porta " + PORT);
});