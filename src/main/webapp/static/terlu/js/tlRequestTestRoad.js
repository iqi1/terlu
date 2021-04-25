	var modify = false;
    $( function() {
    	var id = $("#id").val();
    	console.log(id);
    	if(typeof(id) != "undefined"){
    		initTestRoadBox("null");
    		modify = true;
    	}
    		
    });
    
    function testSelect(data){
    	console.log(data);
    	$('#roads').html("");
    }
    
    function saveData(){
	    $.ajax({
	        url:ctx + '/modules/tlRequestTestRoad/save',
	        type:'post',
	        data:$('#inputForm').serialize(),
	        success:function(){
	            J.popup({
	                html: '保存测试道路成功',
	                pos : 'bottom',
	                showCloseBtn : false
	            })
	        }
	    });
	//$("#inputForm").submit(); 
	//console.log("adfasdfsadfsad");
    }
	
	function initSelectRoad(data){
		var html='<table>';
		for(var ii = 0 ; ii < data.length ; ii ++){
			var rowName = data[ii].rowName;
			rows = data[ii].data;
			var  sels =  rows[0];
			var selected = "";
			var sel2 = sels - rows[3];
			html += "<tr>";
			html += "<th vertical-align='middle !important;'>";
			html += rowName;
			html += "</th>";
			for(var jj = 0 ; jj < sels;  jj ++){
				html += '<th><div class="seats" id="seats"><ul>'
				var checked = "";
				if(rows[1] > jj ){
					checked = ' checked="checked" ';
				}
				
				if(jj >= sel2){
					html+='<li class="backcolor selected">';
				}else{
					html+='<li class="backcolor">';
				}
				
				html+='<input type="checkbox"' + checked + '  name="'+rowName + '_' + data[ii].id + '_' + rows[1] + '" id="seat-'+ii+'-' + jj +'" />';
				html+='<label for="seat-'+ii+'-' + jj +'"></label>';								
				html+='</li></ul></div></th>';
			}
			html += "</tr>";
		}
		
		html += "</table>"
		$('#roads').html(html);
		$('.selected').children('input').attr({'disabled':'disabled','checked':'checked'});
		
		getSelects();
		$('.seats li input').on('click',function(){
			getSelects();

		});
		
		$('#roads').focus();
		
	}
	
	function getSelects(){
		var selects = $('.seats li').not('.selected').children('input:checked')
		///var checklen = selects.length;
		var ids = "";
		for(var ii = 0 ; ii < selects.length; ii ++){
			//console.log(selects[ii].name);
			ids += selects[ii].name;
			ids += ";";
		}
		console.log(ids);
		$('#selects').val(ids);
	}
	
	function initTestRoadBox(requstDate){
		
		if (requstDate == "null") {
			requstDate = $("input[name='startTime']").val();
			console.log(requstDate);
		}
		
		var projectId = $("#projectId").find("option:selected").val();
		
		if(typeof(projectId) == "undefined")
			return;
		console.log(projectId);
		var testRoad = $("#testRoad").find("option:selected").val();
		$.ajax({
            cache: true,
            type: "post",
            url:ctx + "/modules/tlRequestTestRoad/TestRoadInfo",
            data: {date:requstDate,projectId:projectId,testRoad:testRoad},
          // traditional:true,
            error: function(data) {
            	//alert(data.remarks);
            },
            success: function(data) {
				if (data != "null" && data != null 
						&& typeof (data) != "undefined") {
					initSelectRoad(data);

				}

            }
       });
	}