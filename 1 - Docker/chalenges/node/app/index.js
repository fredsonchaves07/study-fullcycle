const nunjucks = require('nunjucks')
const express = require('express')
const path = require('path');
const app = express()
const port = 3000
const mysql = require('mysql')

app.use(express.urlencoded({extended:true}))
app.set("view engine", "njk")

nunjucks.configure('views', {
    autoescape: true,
    express: app
});

app.get("/", (req, res) => {
    getPeoples(res)
})

app.listen(port, async () => {
    console.log('Rodando na porta ', port)
})

function getPeoples(res) {
    const config = {
        host: 'db',
        user: 'root',
        password: 'root',
        database: 'nodedb',
        port: 3306
    }
    const connection = mysql.createConnection(config)
    const sql = `SELECT * FROM people`
    connection.query(sql, (error, results, fields) => {
        res.render("index", {peoples: results});
        connection.end();
    })
}