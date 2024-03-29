import $ from 'jquery';

$(function ($) {
	'use strict';

	// accordion
	$('.accordion-toggle').on('click', function () {
		$(this)
			.closest('.panel-group')
			.children()
			.each(function () {
				$(this).find('>.panel-heading').removeClass('active');
			});

		$(this).closest('.panel-heading').toggleClass('active');
	});

	// Contact form
	const form = $('#main-contact-form');
	form.submit(function (event) {
		event.preventDefault();
		const form_status = $('<div class="form_status"></div>');
		$.ajax({
			url: $(this).attr('action'),

			beforeSend: function () {
				form.prepend(form_status.html('<p><i class="fa fa-spinner fa-spin"></i> Email is sending...</p>').fadeIn());
			},
		}).done(function (data) {
			form_status
				.html('<p class="text-success">' + data.message + '</p>')
				.delay(3000)
				.fadeOut();
		});
	});

	//goto top
	$('.gototop').click(function (event) {
		event.preventDefault();
		$('html, body').animate(
			{
				scrollTop: $('body').offset().top,
			},
			500
		);
	});
});
