$(() => {
	
	$('.delete').click(function() {
		//$(this).parent().slideUp('slow');
		$(this).parent().slideUp(1000, 'easeInOutBounce');
		
	})
	
	$('#view').click(function() {
		$('.pane').slideDown(1000);
		//$('.pane').show(1000);
		//$('.pane').fadeIn(1000);
		//$('.pane').css('display', 'block');
	})
})