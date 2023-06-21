const express = require('express');
const app = express();
const port = 3000;
app.use(express.json());
const arrayRouter = require('./routes/arrayCheck');

app.use('/v1', arrayRouter);

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`);
})