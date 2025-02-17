// alert();

// let text1="text";

// console.log(text1);

let schetchik = 0;
document.querySelector("h1").textContent = schetchik;
document.querySelector("body").addEventListener("click", function(){
    schetchik++;
    document.querySelector("h1").textContent = schetchik;
    console.log(schetchik); 
})