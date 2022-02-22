const goldonhover = document.getElementsByClassName('goldonhover');
for (let i = 0; i < goldonhover.length; i++) {
   goldonhover[i].onmouseenter = function () {
      this.style.color = "#FCFF5F";
   };
   goldonhover[i].onmouseleave = function () {
      this.style.color = "white";
   };
}

const cardImages = document.getElementsByClassName('card-img-nottop');
for (let i = 0; i < cardImages.length; i++) {
   cardImages[i].addEventListener('click', () => {
      cardImages[i].classList.toggle('scaled');
   });
}