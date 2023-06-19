const express = require('express');
const router = express.Router();
const userController = require('../controllers/user');
router.get('/users/create-json', userController.createJson);
router.get('/users', userController.getAllData);
router.get('/users/:country', userController.getDatabyCountry);

module.exports = router;