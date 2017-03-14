<%@ include file="header.jsp" %>
<!--    MAIN SLIDER   -->  

       
        <div style="padding-top:700px" id="myCarousel" class="carousel slide animated zoomIn" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>

          </ol>

          <!-- Wrapper for slides -->
          <div class="carousel-inner" role="listbox">

            <div class="item active">
              <img src="http://www.amith.in/magazine/wp-content/uploads/2015/09/Top-5-4G-mobiles-below-15000.jpg" alt="Chania" width="1920" height="500">
            </div>

            <div class="item">
              <img src="resources/images/b.jpg" alt="Chania" width="1920" height="500">
            </div>

            <div class="item">
              <img src="http://www.amith.in/magazine/wp-content/uploads/2015/09/Top-5-4G-mobiles-below-15000.jpg" alt="Flower" width="1920" height="500">
            </div>
          </div>

          <!-- Left and right controls -->
          <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        
        <script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>
 
        
<!--    MAIN SLIDER ENDS   -->
<%@ include file="footer.jsp" %>   
