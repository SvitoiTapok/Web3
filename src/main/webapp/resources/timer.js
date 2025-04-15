window.onload = function (){
    setInterval(function() {
        // Выполнение обновления страницы через JSF
        var button = document.getElementById("timerForm:timer");
        button.click();
    }, 1000);  // 5000 миллисекунд = 5 секунд
    console.log(document.getElementById("timerForm:NO_BUTTON"))
    let button = document.getElementById("timerForm:NO_BUTTON")
    button.addEventListener('mouseover', ()=>{button.value = "ДА"})
    button.addEventListener('mouseout', () => {button.value = "НЕТ"})
}
