const express = require("express");
const path = require("path");
const app = express();
app.use(express.static(__dirname));

app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "views", "index.html"));
});

app.listen(8079, () => {
  console.log("app listening on port 8079");
});
