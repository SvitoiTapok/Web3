let row_count = 1;
let table;

function getYValue() {
    return document.getElementById("j_idt9:yInput").value
}

function setYValue(y) {
    document.getElementById("j_idt9:yInput").value = y
    var event = new Event('change', {
        'bubbles': true,
        'cancelable': true
    });

    // Отправляем событие
    document.getElementById("j_idt9:yInput").dispatchEvent(event);

}

function getXValue() {
    return PF('spinnerWidget').getValue();
}

function setXValue(x) {
    var spinner = PF('spinnerWidget')
    spinner.setValue(x);
    spinner.input.trigger('change');
    //let xMessage  = document.getElementById("xMessage");
    //xMessage.setAttribute("color","black");
    //xMessage.innerText = "Сейчас выбран x = "
    //let xValue = document.getElementById("xValue");
    //xValue.innerText = x
}

function getRValue() {
    console.log("hoh")
    return PF('inputWidget').getValue();
    //return document.getElementById("rInput").innerText
}


function validateY(){
    let y = getYValue()
    if (y === "") {
        setYValue(0)
    }
    const int = new RegExp("^-?[0-9]+$");
    const double = new RegExp("^-?[0-9]+.[0-9]+$");
    if(!(int.test(y)||double.test(y))){
        setYValue(0)
    }
    let number = parseFloat(y);
    if(number<-5)
        setYValue(-5)
    if(number>3)
        setYValue(3)

}

function drawCurrentDot(color) {
    //if(validateX()&&validateY()&&validateR()){
    let x = 250 + parseFloat(getXValue()) * 200 / parseFloat(getRValue())
    let y = 250 - parseFloat(getYValue()) * 200 / parseFloat(getRValue())
    console.log(x + " " + y)
    drawDotAndSubmit(x, y, color)
    //}
}

//    if(validateY()&&validateR()) {
//        let svg = document.getElementById("svg")
//        let x = document.forms["xyrForm"]["x"].value;
//        let y = document.forms["xyrForm"]["y"].value;
//        console.log(x);
//        console.log(y);
//        let r = getR();
//        console.log(r);
//
//
//        const dot = document.getElementById("dot")
//        //const dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
//        dot.setAttribute("r", "5");
//        //dot.setAttribute("fill", "red");
//        let cx = x*200/r+250; let cy = -y*200/r+250;
//        console.log(cx.toString());
//        console.log(cy.toString());
//        dot.setAttribute("cx", cx.toString());
//        dot.setAttribute("cy", cy.toString());
//        //svg.appendChild(dot);
//    }

function handleResponse(data) {
    //таблица
    let re = new RegExp('<table id="results" border="1">.*</table>', "s");
    let table = document.getElementById("results")
    //const re = new RegExp("<tr>.*</tr>", "s");
    console.log(data)
    let newtable = data.match(re)[0];
    newtable = newtable.replace('<table id="results" border="1">', "").replace('</table>', "")
    table.innerHTML = newtable
    //графика
    re = new RegExp('<td>-?[0-9]\.[0-9]+ -?[0-9]\.[0-9]+ [0-9].[0-9]+<\/td>', 'g')
    let dots = data.match(re);
    for (let xyr in dots) {
        let xyr1 = dots[xyr].replace("<td>", "").replace("</td>", "")
        console.log(xyr1)
        let list = xyr1.split(" ");
        console.log(list)
        let x = list[0];
        let y = list[1];
        let r = list[2];
        console.log(x, y, r);
        drawNewDot(x, y, r, "red");
        repaint()

    }
    console.log(dots)
    //table = document.querySelector('#results tbody');
    //const firstRow = table.querySelector('tr');
    //firstRow.remove();
    //const rows = table.querySelectorAll('tr');
    //if (rows.length>5) {
    //    const rows = table.querySelectorAll('tr');
    //    const lastRow = rows[rows.length - 1]; // выбираем последнюю строку
    //    lastRow.remove();
    //}
//
    //table.insertAdjacentHTML('afterbegin', row);
    //table.insertAdjacentHTML('afterbegin', "<tr>\n" +
    //    "                <td>X, Y, R</td>\n" +
    //    "                <td>Попадание</td>\n" +
    //    "                <td>Время обращения к серверу</td>\n" +
    //    "                <td>Время обработки запроса, нс</td>\n" +
    //    "            </tr>")
//
    //console.log(rows.length);

}

function handleresp1(data) {
    let info = document.getElementById("submitInfo")
    info.innerText = data
}
function setMessage(msg){
    let label = document.getElementById("submitInfo")
    label.innerText = msg


}


function validateAndSubmit() {
    if (validateX() && validateY() && validateR()) {
        submit();
    }
    return false;
}


function drawClickedDot(e) {
    drawDotAndSubmit(e.offsetX, e.offsetY);

}
function drawDotByParams(){
    let r = getRValue();
    let x = getXValue()
    let y = getYValue()
    // setTimeout(() => {
    //     drawNewDot(x*100*2/r+250, -y*100*2/r+250, r)
    // }, 100)


}

function drawDotAndSubmit(x, y) {
    let r = getRValue();
    setXValue(Math.round((x - 250) / 200 * r * 100) / 100)
    setYValue(Math.round(-(y - 250) / 200 * r * 100) / 100)
        submit()
        // setTimeout(() => {
        //     drawNewDot(x, y, r)
        // }, 100)

        // function drawDotAndSubmit(x, y){
        //     //if(validateR()) {
        //     let r = getRValue();
        //     drawNewDot(x, y, r, "green")
        //
        //let dot = document.getElementById("dot")
        ////const dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
        //dot.setAttribute("r", "5");
        ////dot.setAttribute("fill", "red");
        //let cx = x;
        //let cy = y;
        //dot.setAttribute("cx", cx.toString());
        //dot.setAttribute("cy", cy.toString());
//
        //setXValue(Math.round((cx-250)/200*r*100)/100)
        //setYValue(Math.round(-(cy-250)/200*r*100)/100)
        //svg.appendChild(dot);
}
function submit(){
    let event = new Event('click', {
        'bubbles': true,
        'cancelable': true
    });

    // Отправляем событие
    document.getElementById("j_idt9:submit").dispatchEvent(event);
}

function drawNewDot(x, y, r, hit) {
    // console.log(x)
    // console.log(r)
    // let table = document.getElementById("table")
    // let row = table.rows[table.rows.length - 1]
    // let cell = row.cells[1]
    // let hit = cell.textContent || cell.innerText;
    let color = "green"
    if(hit.includes("false"))
        color="red"
    let xs = 250+parseFloat(x)*200/parseFloat(r);
    let ys = 250-parseFloat(y)*200/parseFloat(r);
    let svg = document.getElementById("svg")
    const dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    dot.setAttribute("fill", color);
    dot.setAttribute("r", "5");
    dot.setAttribute("stroke", "black")
    dot.setAttribute("name", r)

    let cx = xs;
    let cy = ys;
    dot.setAttribute("cx", cx.toString());
    dot.setAttribute("cy", cy.toString());
    console.log(svg)
    svg.appendChild(dot);

}

function repaint() {
    let r = parseFloat(getRValue())
    document.querySelectorAll("circle").forEach((e) => {
        let r1 = e.getAttribute("name")
        console.log(e.getAttribute("name"))
        let cx = e.getAttribute("cx")
        let cy = e.getAttribute("cy")
        console.log(cx, cy, r, r1)
        e.setAttribute("cx", (cx - 250) / r * r1 + 250)
        e.setAttribute("cy", (cy - 250) / r * r1 + 250)
        e.setAttribute("name", r)
    })
}
function recolor_rect(pers){
    let e = document.getElementById("myRect")
    e.setAttribute("width", pers*100)
    console.log("kdafaskldjfkasdjf")

}

//console.log("ajlsdkfjasd")