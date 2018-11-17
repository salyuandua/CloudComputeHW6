$(function(){
	//======================search
	$("#search").click(function(){
		var formData={};
		$.each($(".ui.form").find("input"),function(i,k){
			if($(k).val()!=""){
				var key=$(k).attr("name");
				var value=$(k).val();
				formData[key]=value;
			}
			
		});
		console.log(formData);
		
		
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
		//oppo type dropdown
		$("#oppo_type_drop").dropdown();
		//tab
		$(".ui.pointing.secondary.blue.menu.item").tab();
		
		
		var allDataLoaded=false;
		function loadList(){
			var listLength=$('.ui.divided.items').children(".item").length;
			var from=listLength;
			var end=listLength+20;
			$(".ui.centered.inline.loader").addClass("active");
			$.ajax({
				url:"list",
				method:"POST",
				data:{'from':from,'end':end},
				success:function(data){
					$('.ui.divided.items').append(data);
					if($(data).length<20){
						allDataLoaded=true;
						$(".ui.horizontal.divider.header").html("No More Data");
					}
					$(".ui.centered.inline.loader").removeClass("active");
				},
				error:function(){
					$(".ui.centered.inline.loader").removeClass("active");
					
				}
				});
			
		}
		
		
		
		//init oppo list
		$.ajax({
			url:"list",
			method:"POST",
			data:{from:0,end:20},
			success:function(data){
				$(".ui.divided.items").append(data);
				//inifnite load
				$('.ui.divided.items')
				  .visibility({
				    once: false,
				    // update size when new content loads
				    observeChanges: true,
				    // load content on bottom edge visible
				    onBottomVisible: function() {

				     if(!allDataLoaded){
				    	 loadList();
				    	 
				    	 
				     }	
				     	
				      
				    }
				  });
			},
			error:function(){
				
			}
			
		});
		

		
		
		
	});