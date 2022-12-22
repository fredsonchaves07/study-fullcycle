const express = require('express')
const path = require('path');
const app = express()
const port = 3000
const config = {
    host: 'db',
    user: 'root',
    password: 'root',
    database: 'nodedb',
    port: 3306
}
const mysql = require('mysql')
const connection = mysql.createConnection(config)
//const sql = `insert into people(name) values('Fred')`
//connection.query(sql)

app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname+'/index.html'))
})

app.listen(port, () => {
    console.log('Rodando na porta ', port)
})