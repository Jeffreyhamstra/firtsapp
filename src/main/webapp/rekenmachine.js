function rekenmachine() {

}
function clickFunction(number) {
	a = document.getElementById("display").innerHTML;
	x = a + number.value;
	document.getElementById("display").innerHTML = x;	
};

function clickClearFunction() {
	document.getElementById("display").innerHTML = 0;
};


