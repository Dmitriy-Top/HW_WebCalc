$( document ).ready(function() {
    $( '#input_field' ).hover(function() {
  $( '#help' ).slideUp( "fast");
});

$( '#input_field' ).mouseleave(function() {
  $( '#help' ).slideDown( "fast");
});

$( "#history" ).click(function() {
  $.get( "./?calc_expr=history", function( data ) {
  $( "#history_view" ).html( data );
  $( '#history_view' ).slideDown( "slow");
  });

});

$( '#input_field' ).keyup(function() {
   var data = $( '#input_field' ).val();
   var array = Array.from(data);
   var right_char = ["+", "-", "*", "/", ".", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"];
   var position = array.length - 1;
   var char = array[position];
   var isValid
   var result

   for(i=0;i < right_char.length; i++ ){
   if(right_char[i]==char) isValid=true;
   if(char=='+'||char=='-'||char=='*'||char=='/'&&position!=0&&array[position-1]!==' '){
   array[position]=' ';
   array[position+1]=char;
   array[position+2]=' ';
   }
   }
   if(!isValid){
   array[position]='';
   };
   $( '#input_field' ).val(array.join(""));


});

$(".form").submit(function(){ 
		var form = $(this);
		var error = false;
		if ($('#input_field').val() == '') {
				$('#input_field').attr("placeholder", "Необходмо заполнить");
				error = true;
			}
		if (!error) {
			var data = form.serialize();
			$.ajax({
			   type: 'POST',
			   url: './',
			   dataType: 'html',
			   data: data,
		       beforeSend: function(data) {
		            form.find('input[type="submit"]').attr('disabled', 'disabled');
		          },
		       success: function(data){
		       		if (data['error']) {
		       			alert(data['error']);
		       		} else { 
		       			$('#input_field').val(data);
		       		}
		         },
		       error: function (xhr, ajaxOptions, thrownError) { 
		            alert(xhr.status);
		            alert(thrownError);
		         },
		       complete: function(data) {
		            form.find('input[type="submit"]').prop('disabled', false);
		         }
		});
		}
		return false;
		});
});