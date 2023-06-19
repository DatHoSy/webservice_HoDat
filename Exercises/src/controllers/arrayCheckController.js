function SumNumber(req, res) {
    const { a, b } = req.query;
    res.send(`Cau1: ${a} + ${b} = ${parseInt(a) + parseInt(b)}`);
}

function CheckIsPrime(req, res) {
    const primeNumb = +req.params.a;
    if (primeNumb == 2) {
        res.send(`${primeNumb} is Prime`);
    } else if (primeNumb < 2) {
        res.send(`${primeNumb} is not Prime`);
    }
    for (let i = 2; i <= (primeNumb / 2); i++) {
        if (primeNumb % i == 0) {
            res.send(`${primeNumb} is not Prime`);
        }
    }
    res.send(`${primeNumb} is Prime`);
}

function CheckBigNumberArray(req, res) {
    const arrayNumb = req.body;
    let bigNum = arrayNumb[0];
    for (let i = 1; i < arrayNumb.length; i++) {
        if (bigNum < arrayNumb[i]) {
            bigNum = arrayNumb[i];
        }
    }
    res.send(`Biggest number in array: ${bigNum}`);
}

function ReverseString(req, res) {
    const input = req.params.string;
    const arrayList = input.split("");
    const size = arrayList.length;
    for (let i = 0; i < (size/2); i++) {
        let a = arrayList[i];
        arrayList[i] = arrayList[size - (i + 1)];
        arrayList[size - (i + 1)] = a;
    }
    res.send(arrayList.join(""));
}

function CheckPalindrome(req, res) {
    const input = req.params.string;
    const arrayList = input.split("");
    const size = arrayList.length;
    for (let i = 0; i < size - i; i++) {
        if (arrayList[i] != arrayList[size - (i + 1)]) {
            res.send(`Array: ${arrayList} is not palindrome`);
        }
    }
    res.send(`Array: ${arrayList} is palindrome `);
}

function CheckTimesIndex(req, res) {
    const strInput = req.params.string;
    const numb = req.params.numb;
    const arrayList = strInput.split("");
    const size = arrayList.length;
    let count = 0;
    for (let i = 0; i < size; i++) {
        if (arrayList[i] === numb) {
            count += 1;
        }
    }
    res.send(`Number index times: ${count} `);
}

function RandomText(req, res) {
    const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    const size = characters.length;
    const numb = req.params.numb;
    let text = '';
    for (let i = 0; i < numb; i++) {
        text += characters.charAt(Math.floor(Math.random() * size));
    }
    res.send(`Random Text: ${text}`);
}

function Factorial(req, res) {
    const numb = req.params.numb;
    let factorial = 1;
    for (let i = 2; i <= numb; i++) {
        factorial *= i;
    }
    res.send(`factorial ${numb} is: ${factorial}`);
}

function SortAsc(req, res) {
    const arrayList = req.body;
    const size = arrayList.length;
    for (let i = 0; i < size; i++) {
        for (let j = 0; j < size; j++) {
            if (arrayList[i] < arrayList[j]) {
                let a = arrayList[i];
                arrayList[i] = arrayList[j];
                arrayList[j] = a;
            }
        }
    }
    res.send(`Sort by Ascending: ${arrayList}`);
}

function CheckAnagram(req, res) {
    const { primaryArray, anagramArray } = req.body;
    const sizePrimaryArray = primaryArray.length;
    const sizeAnagramArray = anagramArray.length;
    if (sizePrimaryArray != sizeAnagramArray) {
        res.send(`Array anagramArray is not anagram of Array primaryArray`);
    }
    for (let i = 0; i < sizeAnagramArray; i++) {
        if (primaryArray[i] != anagramArray[sizeAnagramArray - (i + 1)]) {
            res.send(`Array anagramArray is not anagram of Array primaryArray`);
        }
    }
    res.send(`Array anagramArray is  anagram of Array primaryArray`);
}

function ReturnBookObj(req, res) {
    const {title, author, since} = req.query;
    const bookObj = {
        book: {
            title: title,
            author: author,
            since: since
        }
    }
    res.send(bookObj);
}

function ReturnRectangleObj(req, res) {
    const {long, wide} = req.query;
    const acreage = long * wide;
    const bookObj = {
        rectangle: {
            long: long,
            wide: wide,
            acreage: acreage
        }
    }
    res.send(bookObj);
}


function CheckEvenArray(req, res) {
    const arrayList = req.body;
    const size = arrayList.length;
    let arrayEven = [];
    for (let i = 0; i < size; i++) {
        if (arrayList[i] % 2 == 0) {
            arrayEven.push(arrayList[i]);
        }
    }
    res.send(`Array Even: ${arrayEven}`);
}

function RandomNumb(req, res) {
    const {min, max} = req.query;
    const numb = Math.floor(parseInt(min) + Math.random() * (parseInt(max) - parseInt(min)));
    res.send(`Random Number: ${numb}`);
}

function PerfectNumb(req, res) {
    const numb = req.params.numb;
    const newArray = numb.split("");
    const size = newArray.length;
    let newNumb = 0;
    for (let i = 0; i < size; i++){
        newNumb += parseInt(newArray[i]);
    }
    if (newNumb != parseInt(numb)) {
        res.send(`Number is not ferfect number`);
    }
    res.send(`Perfect number: ${newNumb}`);
}

function FizzBuzz(req, res) {
    const numb = req.params.numb;
    let result = '';
    if (numb % 3 == 0) {
        result += 'Fizz';
    }
    if (numb % 5 == 0) {
        result += 'Buzz';
    }
    res.send(result);
}

function CharAt(req, res) {
    const index = req.params.index;
    const {str} = req.body;
    // const result = str.charAt(index-1);
    // const result = str[index-1];
    const newStr = str.split("");
    res.send(newStr[index-1]);
}

function ChangeTime(req, res) {
    const {time} = req.body;
    const timeList = time.split(".");
    const size = timeList.length;
    let newTime = "";
    let isAM = true;
    if (timeList[0] > 12) {
        newTime += (24 - timeList[0]);
        isAM = false;
    }
    if (size = 2 ) {
        newTime = isAM ? [newTime, timeList[1]].join(".").join("AM") : [newTime, timeList[1]].join(".").join("PM");
    }
    const newStr = str.split("");
    res.send();
}


module.exports = {
    SumNumber
    , CheckIsPrime
    , CheckBigNumberArray
    , ReverseString
    , CheckPalindrome
    , CheckTimesIndex
    , RandomText
    , Factorial
    , SortAsc
    , CheckAnagram
    , ReturnBookObj
    , ReturnRectangleObj
    , CheckEvenArray
    , RandomNumb
    , PerfectNumb
    , FizzBuzz
    , CharAt
    , ChangeTime
};