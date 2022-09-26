
const btn = document.querySelector('.menu-btn')
const nav = document.querySelector('nav')
btn.onclick = function ( )  {
    this.classList.toggle('active')
    nav.classList.toggle('active')
}