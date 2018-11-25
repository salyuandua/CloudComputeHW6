$(function(){
	
	//oppo type dropdown
	$("#oppo_type_drop").dropdown();
	$(".ui.dropdown.item").dropdown();
	//tab
	$(".ui.pointing.secondary.blue.menu.item").tab();
	
	var page=1;
	var allDataLoaded=false;
	var formData={};
	//======================search
	$("#search").click(function(){
		formData={};
		page=1;
		$.each($(".ui.form").find("input"),function(i,k){
			if($(k).is("input[type=text]")&&$(k).val()!=""){
				var key=$(k).attr("name");
				var value=$(k).val();
				formData[key]=value;
			}
			if($(k).is("input[type=checkbox]")&&$(k).parent(".ui.checkbox").checkbox('is checked')){
				var key=$(k).attr("name");
				var value=true;
				formData[key]=value;

			}
		});
		
		
		
		console.log(formData);
		
		loadList(true);
		
		
	});
	
	

		function loadList(isInit){
			$(".ui.centered.inline.loader").addClass("active");
			formData.page=page;
			$.ajax({
				url:"list",
				method:"POST",
				data:formData,
				success:function(data){
					if(isInit){
						$('.ui.divided.items').children().remove();
					}
					
					
					$('.ui.divided.items').append(data);
					if($(data).length<5){
						allDataLoaded=true;
						$(".ui.horizontal.divider.header").html("No More Data");
					}
					$(".ui.centered.inline.loader").removeClass("active");
					page++;
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
			data:{"page":page},
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
				    	 loadList(false);
				    	 
				    	 
				     }	
				     	
				      
				    }
				  });
			},
			error:function(){
				
			}
			
		});
		//==================================================delete
		$(".ui.icon.red.button").click(function(){
			//confirm id existing
			var id=$(this).attr("data-id");
			$.ajax({
				url:"delete?action=checkId",
				method:"POST",
				data:{"id":id},
				success:function(data){
					if(data){
						
					}else{//data is not existing
						
						
						
						
					}
					
					
				},
				error:function(){
					
				}
				
				
			});
			
		});
		
		
		//=========================================add 
		$(".ui.green.icon.button").click(function(){
			$(".ui.fullscreen.modal").modal({
				closeable:false,
				onDeny:function(){
					return true;
				},
				onApprove:function(){
					
					
				}
				
				
			}).modal("show");
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	});