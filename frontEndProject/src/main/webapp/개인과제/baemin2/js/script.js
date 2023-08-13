
let i = 1;

document.addEventListener("wheel", function (e) {
  	console.log( i );
  	document.querySelector('.first'+i).className = 'first'+(i+1);
  	i++;
});
