/**
 * Created by tony on 15/7/14.
 */
function A() {
    this.sayHehe = function() {
        console.log("Hehe");
    }
}

A.prototype.sayHello = function() {
    console.log("Hello world");
}

A.sayHi = function() {
    console.log("Hi");
}

var a = new A();
a.sayHello();
A.sayHi();


// B is derived from A
function B() {

}
B.prototype = new A();

//B.sayHi();
var b = new B();
b.sayHello();
b.sayHehe();

