/**
 * Created by tony on 15/7/15.
 */
window.onload = function() {
    var canvas = document.getElementById("canvas1");
    var context = canvas.getContext("2d");

    canvas.onmousedown = function() {
        var ev = ev || window.event;
        context.moveTo(ev.clientX-canvas.offsetLeft, ev.clientY-canvas.offsetTop);
        console.log(ev.clientX + ", " + canvas.offsetLeft + ", " + ev.clientY + ", " + canvas.offsetTop);
        document.onmousemove = function(ev) {
            var ev = ev || window.event;
            context.lineTo(ev.clientX-canvas.offsetLeft, ev.clientY-canvas.offsetTop);
            context.stroke();
        }

        document.onmouseup = function() {
            document.onmousemove = null;
            document.onmouseup = null;
        }
    }

    // draw rectangle
    context.fillStyle = "red";
    context.strokeStyle = "blue";
    context.lineWidth = 2;
    context.lineJoin = "round";
    context.fillRect(20, 20, 300, 100);
    context.strokeRect(20.5, 20.5, 300, 100);

    var num = 0;

    setInterval(function () {
        num++;

        context.clearRect(0, 0, canvas.width, canvas.height);
        context.fillRect(num, num, 300, 100);
        context.strokeRect(num+0.5, num+0.5, 300, 100);
    }, 30)

    // draw line
    context.beginPath();
    context.moveTo(400, 100);
    context.lineTo(500, 400);
    context.lineTo(300, 500);
    context.closePath();
    context.stroke();

    context.beginPath();
    context.moveTo(400, 300);
    context.lineTo(500, 600);
    context.lineTo(300, 700);
    context.closePath();
    context.stroke();
    context.fill();
}