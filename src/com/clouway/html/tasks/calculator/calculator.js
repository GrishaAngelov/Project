var counter = 0;
var operation;
var firstNum;
var secondNum;
var calculator = {
    "+":new Sumator(),
    "-":new Subtractor(),
    "*":new Multiplicator(),
    "/":new Divisor()
};

var buttonLabels = new Array("1","2","3","4","5","6","7","8","9","0");
function generateButtons(){
    var buttonsDiv = document.getElementsByTagName("div")[1];
    for(var i=0;i<buttonLabels.length;i++){

       var content = document.createElement("button");
        content.setAttribute("type","button");
        content.setAttribute("name",i);
        content.setAttribute("onclick","typeCharacter("+buttonLabels[i]+")");
        content.appendChild(document.createTextNode(buttonLabels[i]));
        buttonsDiv.appendChild(content);
    }

}

generateButtons();

function typeCharacter(buttonName) {
    if (buttonName == '.') {
        if (checkForMoreThanOneDot()) {
            disableDotButton(true);
        }
    }
    else {
        disableDotButton(false);
    }
    var currentTypedCharacters = document.getElementsByTagName("input")[0].value;
    document.getElementsByTagName("input")[0].value = currentTypedCharacters + buttonName;
}

function disableDotButton(booleanValue) {
    document.getElementsByName(".")[0].disabled = booleanValue;
}

function clearLastDigit() {
    var currentTypedCharacters = document.getElementsByTagName("input")[0].value;
    document.getElementsByTagName("input")[0].value = currentTypedCharacters.substr(0, currentTypedCharacters.length - 1);
}

function clearAll() {
    document.getElementsByTagName("input")[0].value = "";
}

function checkForMoreThanOneDot() {
    var isMoreThanOne = false;
    counter++;
    if (counter == 1) {
        isMoreThanOne = true;
    }
    return isMoreThanOne;
}


function Sumator() {
    this.calculate = function (number1, number2) {
        document.getElementsByTagName("input")[0].value = number1 + number2;
    }
}

function Subtractor() {
    this.calculate = function (number1, number2) {
        document.getElementsByTagName("input")[0].value = number1 - number2;
    }
}

function Multiplicator() {
    this.calculate = function (number1, number2) {
        document.getElementsByTagName("input")[0].value = number1 * number2;
    }
}

function Divisor() {
    this.calculate = function (number1, number2) {
        document.getElementsByTagName("input")[0].value = number1 / number2;
    }
}


function numbers(value) {
    firstNum = Number(document.getElementsByTagName("input")[0].value);
    document.getElementsByTagName("input")[0].value = "";
    operation = value;
}

function calculate() {
    secondNum = Number(document.getElementsByTagName("input")[0].value);
    calculator[operation].calculate(firstNum, secondNum);
    operation = "";
}