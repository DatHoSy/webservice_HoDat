const express = require('express');
const app = express();
const port = 8000;
const userRouter = require('./routes/user');

app.use(express.json());

app.use('/v1/', userRouter);

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`);
})