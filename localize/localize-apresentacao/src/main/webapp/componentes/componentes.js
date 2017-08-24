/**
 * <p>
 * <b>Title:</b> twPanel
 * </p>
 * <p>
 * <b>Description:</b> Componente de panel
 * </p>
 * <p>
 * <b>Company: </b> Fábrica de Software - Red & White
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
app.directive("panel", function() {

	return {

		restrict : "E",

		transclude : true,

		replace : true,

		scope : {

			titulo : "@",

			icon : "@",

			addClass : "@"

		},

		templateUrl : '../componentes/panel.html'

	};

});
/**
 * <p>
 * <b>Title:</b> calendar
 * </p>
 * <p>
 * <b>Description:</b> Componente para datepicker do jquery
 * </p>
 * <p>
 * <b>Company: </b> Fábrica de Software - Red & White
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
app.directive('calendar', function($parse) {

	var directiveDefinitionObject = {

		restrict : 'A',

		link : function postLink(scope, iElement, iAttrs) {

			iElement.datepicker({

				changeMonth : true,
				changeYear : true,
				firstDay : 1,
				regional : 'pt-BR',
				dateFormat: 'dd/mm/yy',

				onSelect : function(dateText, inst) {

					scope.$apply(function(scope) {

						$parse(iAttrs.ngModel).assign(scope, dateText);

					});
				}
			});
		}
	};
	return directiveDefinitionObject;
});

app.directive('calendarMesAno', function($parse) {
	
	var directiveDefinitionObject = {
			
			restrict : 'A',
			
			link : function postLink(scope, iElement, iAttrs) {
				
				iElement.datepicker({
					
					changeMonth : true,
					changeYear : true,
					firstDay : 1,
					regional : 'pt-BR',	
					dateFormat: 'mm/yy',
					
					onClose: function () {
	                   var iMonth = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
	                   var iYear = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
	                   $(this).datepicker('setDate', new Date(iYear, iMonth, 1));
		            }
					
				});
			}
	};
	return directiveDefinitionObject;
});


/**
 * <p>
 * <b>Title:</b> showerror
 * </p>
 * <p>
 * <b>Description:</b> Componente para datepicker do jquery
 * </p>
 * <p>
 * <b>Company: </b> Fábrica de Software - Red & White
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
app.directive('validade', function() {

	return {

		restrict : 'A',

		require : '^form',

		link : function(scope, el, attrs, formCtrl) {

			var inputEl = el[0].querySelector("[name]");

			var inputNgEl = angular.element(inputEl);

			var inputName = inputNgEl.attr('name');

			inputNgEl.bind('blur', function() {

				el.toggleClass('has-error', formCtrl[inputName].$invalid);

			});

			scope.$watch(function() {

				return scope.showErrorsCheckValidity;

			}, function(newVal, oldVal) {

				if (!newVal) {

					return;

				}

				el.toggleClass('has-error', formCtrl[inputName].$invalid);

			});

			scope.$watch(function() {

				return scope.showErrorsReset;

			}, function(newVal, oldVal) {

				if (!newVal) {
					return;
				}

				$timeout(function() {

					el.removeClass('has-error');

				}, 0, false);
			});

		}
	};
});



/**
 * <p>
 * <b>Title:</b> ngThumb
 * </p>
 * <p>
 * <b>Description:</b> Componente para mostrar imagem upload.
 * </p>
 * <p>
 * <b>Company: </b> Fábrica de Software - Red & White
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
app.directive('ngThumb', ['$window', function($window) {
    var helper = {
        support: !!($window.FileReader && $window.CanvasRenderingContext2D),
        isFile: function(item) {
            return angular.isObject(item) && item instanceof $window.File;
        },
        isImage: function(file) {
            var type =  '|' + file.type.slice(file.type.lastIndexOf('/') + 1) + '|';
            return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
        }
    };

    return {
        restrict: 'A',
        template: '<canvas/>',
        link: function(scope, element, attributes) {
            if (!helper.support) return;

            var params = scope.$eval(attributes.ngThumb);

            if (!helper.isFile(params.file)) return;
            if (!helper.isImage(params.file)) return;

            var canvas = element.find('canvas');
            var reader = new FileReader();

            reader.onload = onLoadFile;
            reader.readAsDataURL(params.file);

            function onLoadFile(event) {
                var img = new Image();
                img.onload = onLoadImage;
                img.src = event.target.result;
            }

            function onLoadImage() {
                var width = params.width || this.width / this.height * params.height;
                var height = params.height || this.height / this.width * params.width;
                canvas.attr({ width: width, height: height });
                canvas[0].getContext('2d').drawImage(this, 0, 0, width, height);
            }
        }
    };
}]);


