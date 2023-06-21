const express = require('express');
const router = express.Router();
const arrayCheckController = require('../controllers/arrayCheckController');

router.get('/sum-numb', arrayCheckController.SumNumber);
router.get('/check-prime/:a', arrayCheckController.CheckIsPrime);
router.get('/check-big-number-array', arrayCheckController.CheckBigNumberArray);
router.get('/reverse-string/:string', arrayCheckController.ReverseString);
router.get('/check-palindrome-string/:string', arrayCheckController.CheckPalindrome);
router.get('/check-times-index/:string/:numb', arrayCheckController.CheckTimesIndex);
router.get('/random-text/:numb', arrayCheckController.RandomText);
router.get('/factorial/:numb', arrayCheckController.Factorial);
router.get('/sort-ascending', arrayCheckController.SortAsc);
router.get('/check-anagram', arrayCheckController.CheckAnagram);
router.get('/return-book-obj', arrayCheckController.ReturnBookObj);
router.get('/return-rectangle-obj', arrayCheckController.ReturnRectangleObj);
router.get('/check-even-array', arrayCheckController.CheckEvenArray);
router.get('/random-number', arrayCheckController.RandomNumb);
router.get('/perfect-number/:numb', arrayCheckController.PerfectNumb);

module.exports = router;