<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script type="text/javascript"
	src="${context}/static/plugins/echart/echarts.min.js"></script>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		各组员销售业绩 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#">
		<i class="fa"><img src="${context}/static/dist/img/home_ico.png" width="10" height="10"></i>首页</a></li>
		<li class="active">各组员销售业绩</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<!-- form start -->

				<form class="form-inline" id="searchForm">
					<div class="box-body">
						<div class="form-group">
							<label>下单时间：从</label> <input class="form-control"
								onFocus="WdatePicker()" value="${startDate}" name="startDate"
								placeholder="" type="text">
						</div>

						<div class="form-group">
							<label>至</label> <input class="form-control"
								onFocus="WdatePicker()" value="${endDate}" name="endDate"
								placeholder="" type="text">
						</div>
						<button type="button" onclick="queryResult()"
							class="btn btn-primary">搜索</button>
					</div>
				</form>

			</div>
			<!-- /.box -->

		</div>
		<!--/.col (left) -->
	</div>
	<div class="clearfix"></div>
	<div id="mainMap" style="height: 500px; width: 100%;"></div>
</section>

<script type="text/javascript"> 
queryResult();
function queryResult() { //Ajax方式动态获取json格式数据
                $.ajax({
                    type: "post",
                    dataType: "json",
        	        data: $("#searchForm").serialize(),
                    url: "${context}/reportmanage/loadreportbyworker",
                    success : function(data) {
                        if(data.code == 200){
                          var result =data.orderReports;
                          console.log(result);
                          DrawBar(result, "mainMap")
                        }
                    },
                    error: function () {
                        alert("加载数据失败,请重试！");
                    }
                });
            }

function DrawBar(data, id) {
                var xData = [];
                var datas = [];
                for (var i = 0; i < data.length; i++) {//将json格式转换为Echarts的数组格式
                    xData.push(data[i].name || ",");
                    datas.push({ name: data[i].name, value: data[i].count || 0 });
                }
                var myChart = echarts.init(document.getElementById(id));
                var option = {
                    tooltip: {
                    	trigger: 'axis',
                        show: true
                    },
                    title: {
                        text: '各组员销售业绩'
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            saveAsImage : {show: true}
                        }
                    },
                    xAxis: [
                        {
                            type: 'category',
                            data: xData
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                             {
                                 "name":"销量",
                                 "type":"bar",
                                 "data": datas,
                                 itemStyle:{  
                                     normal:{  
                                       color:'#4b5cc4'
                                     }
                                 },
                             }
                    ]
                };
                myChart.setOption(option);
            }
</script>
