function refreshData() {
    x = 5;  // 5 Seconds
    console.log(document.getElementById("myTextarea").value);

    setTimeout(refreshData, x*1000);
}

refreshData(); // execute function