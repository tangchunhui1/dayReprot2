
function btn() {
/*1、当点击button 按钮时
*      通过 ajax  去后台判断返回的json 是否为空，  判断该月份是否有数据？
*
* 如果有数据 就给 X 继续赋值
* 反之 如果没有 将返回当前月
* 就提示没有数据，将返回当前月
*     否则有就显示
* */
    var x = document.getElementById("month").value;


    $.ajax({
        type: "get",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "yueDatas/selectYuedatasByDate",    //请求发送到dataActiont处
        data: {date: x},
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            //$.isEmptyObject(result)  判断result json 对象是否为空
            if ($.isEmptyObject(result) == true) {//假如条件满足

                alert("该月目前没有数据,请选择其它月份！");   //  如果条件不满足 在这 return 但代码还是往下执行
                return;


            } else {
                return;
            }
        },
        /*error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
        }
*/
    });//end ajax

    var resdates = [];
    var junWen = [];
    var junShi = [];
    var ups = [];
    var dongLi = [];
    var zDianLiang = [];
    var cpuJun = [];
    var cpuFen = [];
    var zwyCpuNum = [];
    var zwyNeiCunNum = [];
    var zwyCiPanNum = [];
    var hlwyCpuNum = [];
    var hlwyNeiCunNum = [];
    var hlwyCiPanNum = [];
    var gongXiangCpu = [];
    var xieTongCpu = [];
    var jiYueCpu = [];
    var yiDianCpu = [];
    var reXianCpu = [];
    var zwyFlow = [];
    var hlwyFlow = [];



    /*温湿度曲线图*/
    var myChart1 = echarts.init($("#echart1")[0]);

    option1 = {

        title: {    //图表标题
            text: '温湿度曲线图',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                fontSize:'210%',
                color:'#fffafa',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            /* y: 'top',*///垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
            y: 5,
        },
        backgroundColor: 'rgba(9,18,86,0.98)',
        toolbox: { //可视化的工具箱
            show: true,

            feature: {
                restore: { //重置
                    show: true
                },
                dataZoom: { //数据缩放视图
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                }
            }
        },
        tooltip: {
            /*注释掉会显示全部类别的值*/
            /*formatter: "{a}<br/>{b}<br/>{c}",
            trigger: 'item',*/
            trigger: 'axis',//坐标轴触发提示框，多用于柱状、折线图中
            show: true,
            axisPointer: {
                type: 'shadow'
            }
        },
        //显示比例
        grid: {
            x: '3%',
            y: '30%',
            x2:'3%',
            y2: '3%',
            /* borderWidth: 0*/
            containLabel: true,//防止溢出
            width:'auto',//图例宽度
            height:'auto'//图例高度
        },
        /*图表上方的类别显示*/
        color: [
            '#FF3333',    //温度曲线颜色
            '#53FF53',    //湿度曲线颜色
        ],
        //图例设置
        legend: {
            top: '18%',
            left: '40%',
            itemWidth: 12,
            itemHeight: 12,
            data: ['温度','湿度'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize:'120%',
            },
        },


        /*表示是否设置了拖拽用的手柄，如果为false则拖拽结束时，才更新视图。如果为ture则拖拽手柄过程中实时更新图表视图。*/
        /*calculable: true,*/

        //数据区域缩放、滚动条
        /*dataZoom: [
            {
                type: 'slider',    //支持鼠标滚轮缩放
                start: 0,            //默认数据初始缩放范围为10%到90%
                end: 100
            },
            {
                type: 'inside',    //支持单独的滑动条缩放
                start: 0,            //默认数据初始缩放范围为10%到90%
                end: 100
            }
        ],*/


        xAxis: {    //X轴
            /*name:"日期",*/
            type: 'category',
            nameTextStyle :{
                fontSize: '120%'
            },
            splitLine: {
                show: false,
            },
            axisLine: {
                lineStyle: {
                    color: '#675bba'
                }
            },
            axisLabel: {
                show: true,
                textStyle: {
                    color: '#a4a7ab',
                    fontSize:'120%',  //更改坐标轴文字大小
                    align: 'center'
                }
            },
            data: resdates
            /*['01', '02', '03', '04', '05', '06', '07', '08', '09', '11', '12',
            '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24'],*/ //先设置数据值为空，后面用Ajax获取动态数据填入
        },

        yAxis: [    //Y轴（这里我设置了两个Y轴，左右各一个）
            {//第一个（左边）Y轴，yAxisIndex为0
                type: 'value',
                name: '温度',
                nameTextStyle :{
                    fontSize: '150%'
                },
                /*max: 100,
                min: 0,*/
                scale: true,
                splitLine: {
                    show: false,
                },
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                axisLabel: {
                    formatter: '{value}℃ ',
                    textStyle: {
                        color: '#fefff9',
                        align: 'right',
                        fontSize:'120%',  //更改坐标轴文字大小
                    }
                }
            },
            {
                //第二个（右边）Y轴，yAxisIndex为1
                type: 'value',
                name: '湿度',
                nameTextStyle :{
                    fontSize: '150%'
                },
                /*max: 100,
                min: 0,*/
                scale: true,
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                splitLine: {
                    show: false,
                },
                axisLabel: {
                    formatter: '{value}%',
                    textStyle: {
                        color: 'rgb(255,255,253)',
                        align: 'left',
                        fontSize:'120%',  //更改坐标轴文字大小
                    }
                }
            }

        ],
        series: [    //系列（内容）列表
            {
                name: '温度',
                type: 'line',    //折线图表示（生成温度曲线）
                symbol: 'emptycircle',    //设置折线图中表示每个坐标点的符号；emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
                yAxisIndex:0,
                data: junWen
                /*[23, 24, 26, 30, 34, 44, 29, 45, 34, 45, 23, 24, 26,
                    30, 34, 44, 29, 45, 34, 45, 24, 26, 30, 34] */       //数据值通过Ajax动态获取
            },

            {
                name: '湿度',
                type: 'line',
                symbol: 'emptyrect',
                /*显示第二个Y轴坐标值*/
                yAxisIndex:1,
                data: junShi
                /*[33, 34, 36, 40, 44, 54, 39, 55, 44, 55, 33, 34, 36,
                    40, 44, 54, 39, 55, 44, 55, 34, 36, 40, 44]*/
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。

    /*myChart1.setOption(option1);

    window.addEventListener("resize", function () {
        myChart1.resize();
    })*/


    /*电能类型与用量*/

    var myChart2 = echarts.init($("#echart2")[0]);

    option2 = {
        title: {    //图表标题
            text: '电能类型与用量',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                fontSize:'210%',
                color:'#fffafa',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            /* y: 'top',*///垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
            y: 5,
        },
        backgroundColor: 'rgba(9,18,86,0.98)',
        toolbox: { //可视化的工具箱
            show: true,

            feature: {
                restore: { //重置
                    show: true
                },
                dataZoom: { //数据缩放视图
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                }
            }
        },
        animation: true,

        tooltip: {
            trigger: 'axis',//坐标轴触发提示框，多用于柱状、折线图中
            show: true,
            axisPointer: {
                type: 'shadow'
            }
        },

        //显示比例
        grid: {
            x: '3%',
            y: '30%',
            x2:'9%',
            y2: '3%',
            /* borderWidth: 0*/
            containLabel: true,//防止溢出
            width:'auto',//图例宽度
            height:'auto'//图例高度
        },

        calculable: true,
        /* 图标位置样式*/
        legend: {
            /* itemWidth: 12,
            itemHeight: 12,*/
            top: '18%',
            left: '40%',
            data: ['UPS','动力','总电量'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize:'120%',
            }
        },
        xAxis: [
            {
                name:"日期",
                nameTextStyle :{
                    fontSize: '150%'
                },
                type: 'category',
                data: resdates,
                /* ['01', '02', '03', '04', '05', '06', '07', '08', '09', '11', '12',
                 '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24'],*/
                splitLine: {
                    show: false
                },
                axisLine: {
                    lineStyle: {
                        color: '#675bba',

                    }
                },
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#a4a7ab',
                        fontSize:'120%',  //更改坐标轴文字大小
                        align: 'center'
                    }
                }

            }
        ],

        yAxis: [    //Y轴（这里我设置了两个Y轴，左右各一个）
            {
                //第一个（左边）Y轴，yAxisIndex为0
                type: 'value',
                name: '电量',
                nameTextStyle :{
                    fontSize: '150%'
                },
                min: 0,
                scale: true,
                splitLine: {
                    show: false,
                },
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                axisLabel: {
                    formatter: '{value}KW',
                    textStyle: {
                        color: '#fefff9',
                        align: 'right',
                        fontSize:'120%'//更改坐标轴文字大小
                    }
                }
            }
        ],

        series: [
            {
                name: 'UPS',
                type: 'bar',
                //stack 意为堆叠
                stack: '电量',
                data: ups,
                /*[120, 132, 101, 134, 90, 150, 170, 120, 132, 101, 134, 90, 150,
            170, 120, 132, 101, 134, 90, 150, 170, 132, 101, 134, 90],*/
                barWidth: 7,//柱图宽度
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: true,
                itemStyle: {
                    normal: {
                        color: "#4c00ff"
                    }
                }
            },
            {
                name: '动力',
                type: 'bar',
                //stack 意为堆叠
                stack: '电量',
                data: dongLi,
                /*[220, 232, 201, 234, 190, 250, 270, 220, 232, 201, 234, 190,
            250, 270, 220, 232, 201, 234, 190, 250, 270, 220, 232, 201],*/
                itemStyle: {
                    normal: {
                        color: "#ffe301"
                    }
                }
            },
            {
                name: '总电量',
                type: 'bar',
                //stack 意为堆叠
                stack: '电量',
                data: zDianLiang,
                /* [320, 332, 301, 334, 290, 350, 370, 320, 332, 301, 334, 290, 350,
                370, 320, 332, 301, 334, 290, 350, 370, 320, 332, 301, 334],*/
                itemStyle: {
                    normal: {
                        color: "#ff00f6"
                    }
                }
            }

        ]
    };

    /*myChart2.setOption(option2);
    window.addEventListener("resize", function () {
        myChart2.resize();
    })*/


    /*物理服务器负载趋势图*/

    // 基于准备好的dom，初始化echarts实例
    var myChart3 = echarts.init($("#echart3")[0]);

    option3 = {
        title: {    //图表标题
            text: '物理服务器负载趋势图',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                fontSize:'210%',
                color:'#fffafa',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            /* y: 'top',*///垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
            y: 3,
            /*left:4*/
        },
        backgroundColor: 'rgba(9,18,86,0.98)',

        toolbox: { //可视化的工具箱
            show: true,
            feature: {
                restore: { //重置
                    show: true
                },
                dataZoom: { //数据缩放视图
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                }
            }
        },
        animation: true,
        //显示比例
        grid: {
            x: '5%',
            y: '30%',
            x2:'9%',
            y2: '3%',
            /* borderWidth: 0*/
            containLabel: true,//防止溢出
            width:'auto',//图例宽度
            height:'auto'//图例高度
        },
        tooltip: {
            /*注释掉会显示全部类别的值*/
            /*formatter: "{a}<br/>{b}<br/>{c}",
               trigger: 'item',*/
            trigger: 'axis',//坐标轴触发提示框，多用于柱状、折线图中
            show: true,
            axisPointer: {
                type: 'shadow'
            }
        },

        legend: {
            top: '18%',
            left: '20%',
            data: ['cpu峰值使用率', 'cpu平均使用率'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize:'120%',  //更改坐标轴文字大小
            }
        },
        color: ['#a4d8cc', '#25f3e6'],

        calculable: true,
        xAxis: [
            {
                name:"日期",
                nameTextStyle :{
                    fontSize: '150%'
                },
                type: 'category',

                axisTick: {show: false},
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                boundaryGap: false,
                axisLabel: {
                    textStyle: {
                        color: 'rgb(255,255,253)',
                        fontSize:'120%',  //更改坐标轴文字大小
                    },

                },
                data: resdates
                /*['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12',
                    '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24']*/
            }
        ],
        yAxis: [    //Y轴（这里我设置了两个Y轴，左右各一个）
            {
                //第一个（左边）Y轴，yAxisIndex为0
                type: 'value',
                name: '使用率',
                nameTextStyle :{
                    fontSize: '150%'
                },
                scale: true,
                splitLine: {
                    show: false,
                },
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                axisLabel: {
                    formatter: '{value}%',
                    textStyle: {
                        color: '#fefff9',
                        align: 'right',
                        fontSize:'120%',  //更改坐标轴文字大小
                    }
                }
            }
        ],
        series: [
            {
                name: 'cpu平均使用率',
                type: 'line',
                areaStyle: {
                    normal: {
                        type: 'default',
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 0.8, [{
                            offset: 0,
                            color: '#f3ced3'
                        }, {
                            offset: 1,
                            color: '#ff7709'
                        }], true)
                    }
                },
                smooth: true,
                itemStyle: {
                    normal: {areaStyle: {type: 'default'}}
                },
                data: cpuJun
                /*[500, 830, 710, 521, 504, 660, 530, 410, 710, 312, 321, 754,
                 500, 830, 710, 521, 504, 660, 530, 410, 410, 710, 312, 321, 534]*/
            },
            {
                name: 'cpu峰值使用率',
                type: 'line',
                areaStyle: {
                    normal: {
                        type: 'default',
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 0.8, [{
                            offset: 0,
                            color: '#25f3e6'
                        }, {
                            offset: 1,
                            color: '#0089ff'
                        }], false)
                    }
                },

                smooth: true,
                itemStyle: {
                    normal: {areaStyle: {type: 'default'}}
                },
                data: cpuFen
                /*[710, 312, 321, 754, 500, 830, 710, 521, 504, 660, 530, 410,
                710, 312, 321, 754, 500, 830, 710, 521, 504, 660, 530, 410, 434]*/
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    /*myChart3.setOption(option3);
    window.addEventListener("resize", function () {
        myChart3.resize();

    })*/


    /*工单类型占比与数量*/

// 基于准备好的dom，初始化echarts实例
    var myChart4 = echarts.init($("#echart4")[0]);

    var res = [];    //横坐标数组（实际用来盛放X轴坐标值）

    option4 = {
        title: {    //图表标题
            text: '工单类型占比与数量',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                fontSize:'210%',
                color:'#fffafa',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            /* y: 'top',*///垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
            y: 5,
        },
        backgroundColor: 'rgba(9,18,86,0.98)',
        animation: true,
        toolbox: { //可视化的工具箱
            show: true,

            feature: {
                restore: { //重置
                    show: true
                },
                dataZoom: { //数据缩放视图
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                }
            }
        },

        //显示比例
        grid: {
            x: '3%',
            y: '30%',
            x2:'3%',
            y2: '3%',
            /* borderWidth: 0*/
            containLabel: true,//防止溢出
            width:'auto',//图例宽度
            height:'auto'//图例高度
        },
        tooltip: {
            /*注释掉会显示全部类别的值*/
            /*formatter: "{a}<br/>{b}<br/>{c}",
            trigger: 'axis',*/
            trigger: 'item',//坐标轴触发提示框，多用于柱状、折线图中   item 单个t
            show: true,
            formatter: "{a}<br/>{b}:{c}({d}%)",
            position: function (p) {   //其中p为当前鼠标的位置
                return [p[0] + 10, p[1] - 10];
            },
            axisPointer: {
                type: 'shadow'
            }
        },

        legend: {
            top: '18%',
            left: '80%',
            itemWidth: 12,
            itemHeight: 12,
            data: ['请求', '事件', '变更', '问题'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize:'120%'  //更改坐标轴文字大小
            }
        },

        series: [
            {
                name: '工单占比与数量',
                type: 'pie',
                top: 25,
                left: 2,
                /*roseType : 'area',*/
                /*center: ['50%', '40%'],*/
                radius: ['40%', '75%'],
                color: ['#0054ff', '#00ffff', '#01ff0c', '#9700ff'],
                label: {position: 'out',show: true,formatter: "{b}: {c} ({d}%)"},
                data: res,
                /*label: {normal: {position: 'inner',formatter: "{b}: {c} ({d}%)"}},*/
                labelLine: {normal: {show: true}},
            }],
    };


    $.ajax({
        type: "get",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "gongdan/selectdongdanByDate",    //请求发送到dataActiont处
        data: {date: x},
        dataType: "json",        //返回数据形式为json
        success: function (data) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            debugger
            //把后台返回的数据给数组赋值
            $.each(data, function (key, v) {
                res.push({
                    name: v.gdType,
                    value: v.gdNum
                })
            })
            // 使用刚指定的配置项和数据显示图表。
            myChart4.setOption(option4)

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart4.hideLoading();
        }
    });//end ajax

    window.addEventListener("resize", function () {
        myChart4.resize();
    });


    /*云资源分配比例*/

    var myChart5 = echarts.init($("#echart5")[0]);
    option5 = {
        title: {    //图表标题
            text: '云资源分配比例',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                fontSize:'210%',
                color:'#fffafa',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            /* y: 'top',*///垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
            y: 5,
        },
        backgroundColor: 'rgba(9,18,86,0.98)',
        toolbox: { //可视化的工具箱
            show: true,

            feature: {
                restore: { //重置
                    show: true
                },
                dataZoom: { //数据缩放视图
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                }
            }
        },
        tooltip: {
            /*注释掉会显示全部类别的值*/
            /*formatter: "{a}<br/>{b}<br/>{c}",
            trigger: 'item',*/
            trigger: 'axis',//坐标轴触发提示框，多用于柱状、折线图中
            show: true,
            axisPointer: {
                type: 'shadow'
            }
        },

        //显示比例
        grid: {
            x: '3%',
            y: '30%',
            x2:'3%',
            y2: '3%',
            /* borderWidth: 0*/
            containLabel: true,//防止溢出
            width:'auto',//图例宽度
            height:'auto'//图例高度
        },

        calculable: false,

        legend: {
            top: '15%',
            left: '40%',
            data:['CPU','内存','存储'],
            textStyle: {
                color: "#e9ebee",
                fontSize:'120%'

            }
        },
        xAxis: [
            {
                /*name:"日期",*/
                nameTextStyle :{
                    fontSize: '150%'
                },
                type: 'category',
                data: resdates,
                /*['01', '02', '03', '04', '05', '06', '07', '08', '09', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24'],*/
                splitLine: {
                    show: false,
                },
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                axisLabel: {
                    formatter: '{value} ',
                    show: true,
                    textStyle: {
                        color: '#a4a7ab',
                        fontSize:'120%',  //更改坐标轴文字大小
                        align: 'center'

                    }
                }

            }
        ],
        yAxis: [    //Y轴（这里我设置了两个Y轴，左右各一个）
            {//第一个（左边）Y轴，yAxisIndex为0
                type: 'value',
                name: '核数',
                nameTextStyle :{
                    fontSize: '150%'
                },
                /*max: 100,
                min: 0,*/
                scale: true,
                splitLine: {
                    show: false,
                },
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                axisLabel: {
                    formatter: '{value}核',
                    textStyle: {
                        color: '#fefff9',
                        align: 'right',
                        fontSize:'120%',  //更改坐标轴文字大小
                    }
                }
            },
            {
                //第二个（右边）Y轴，yAxisIndex为1
                type: 'value',
                name: '存量',
                nameTextStyle :{
                    fontSize: '150%'
                },
                /*max: 100,
                min: 0,*/
                scale: true,
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                splitLine: {
                    show: false,
                },
                axisLabel: {
                    formatter: '{value}GB',
                    textStyle: {
                        color: 'rgb(255,255,253)',
                        align: 'left',
                        fontSize:'120%',  //更改坐标轴文字大小
                    }
                }
            }

        ],
        series: [

            {
                name: 'CPU',
                type: 'bar',
                /*显示第1个Y轴坐标值*/
                yAxisIndex:0,
                data: hlwyCpuNum,
                /*[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3,
                 2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],*/
                itemStyle: {
                    normal: {
                        color: "#4c00ff"
                    }
                }
            },
            {
                name: '内存',
                type: 'bar',
                /*显示第二个Y轴坐标值*/
                yAxisIndex:1,
                data: hlwyNeiCunNum,
                /* [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3,
                2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],*/
                itemStyle: {
                    normal: {
                        color: "#7acfff"
                    }
                }
            },
            {
                name: '存储',
                type: 'line',
                /*显示第二个Y轴坐标值*/
                yAxisIndex:1,
                data: hlwyCiPanNum,
                /* [26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 26.4, 28.7, 70.7,
                50.9, 79.0, 56.4, 38.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],*/
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: true,
                itemStyle: {
                    normal: {
                        color: "#1fffce"
                    }
                }
            }
        ]
    };


    // 使用刚指定的配置项和数据显示图表。
    /*myChart5.setOption(option5);
    window.addEventListener("resize", function () {
        myChart5.resize();

    })*/


    /*各域流量统计*/

    // 基于准备好的dom，初始化echarts实例
    var myChart6 = echarts.init($("#echart6")[0]);

    option6 = {
        title: {    //图表标题
            text: '各域流量统计',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                fontSize:'210%',
                color:'#fffafa',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            /* y: 'top',*///垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
            y: 5,
        },
        backgroundColor: 'rgba(9,18,86,0.98)',
        toolbox: { //可视化的工具箱
            show: true,

            feature: {
                restore: { //重置
                    show: true
                },
                dataZoom: { //数据缩放视图
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                }
            }
        },
        //显示比例
        grid: {
            x: '3%',
            y: '30%',
            x2:'9%',
            y2: '3%',
            /* borderWidth: 0*/
            containLabel: true,//防止溢出
            width:'auto',//图例宽度
            height:'auto'//图例高度
        },
        tooltip: {
            /*注释掉会显示全部类别的值*/
            /*formatter: "{a}<br/>{b}<br/>{c}",
            trigger: 'item',*/
            trigger: 'axis',//坐标轴触发提示框，多用于柱状、折线图中
            show: true,
            axisPointer: {
                type: 'shadow',
                lineStyle: {
                    color: '#dddc6b'
                }
            }
        },

        legend: {
            top: '18%',
            left: '40%',
            data: ['电子政务域', '互联网域'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize:'120%',
            }
        },

        xAxis: [{
            name:"日期",
            nameTextStyle :{
                fontSize: '150%'
            },
            type: 'category',
            boundaryGap: false,
            axisLabel: {
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize : '120%',  //更改坐标轴文字大小
                },
            },
            axisLine: {
                lineStyle: {
                    color: '#675bba'
                }
            },

            data: resdates
            /*['01', '02', '03', '04', '05', '06', '07', '08', '09', '11', '12',
            '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24']*/

        }, {

            axisPointer: {show: false},
            axisLine: {show: false},
            position: 'bottom',
            offset: 20,


        }],

        yAxis: [    //Y轴（这里我设置了两个Y轴，左右各一个）
            {//第一个（左边）Y轴，yAxisIndex为0
                type: 'value',
                name: '流量',
                nameTextStyle :{
                    fontSize: '150%'
                },
                /*max: 100,
                min: 0,*/
                scale: true,
                splitLine: {
                    show: false,
                },
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                axisLabel: {
                    formatter: '{value}MB ',
                    textStyle: {
                        color: '#fefff9',
                        align: 'right',
                        fontSize:'120%'  //更改坐标轴文字大小
                    }
                }
            }
        ],
        series: [
            {
                name: '电子政务域',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {

                    normal: {
                        color: '#0184d5',
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(1, 132, 213, 0.4)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(1, 132, 213, 0.1)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#0184d5',
                        borderColor: 'rgba(221, 220, 107, .1)',
                        borderWidth: 12
                    }
                },
                data: zwyFlow,
                /*[3, 4, 3, 4, 3, 4, 3, 6, 2, 4, 2, 4, 3, 4, 3, 4, 3, 4, 3, 6, 2, 4, 2, 4]*/

            },
            {
                name: '互联网域',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {

                    normal: {
                        color: '#00d887',
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(0, 216, 135, 0.4)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(0, 216, 135, 0.1)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#00d887',
                        borderColor: 'rgba(221, 220, 107, .1)',
                        borderWidth: 12
                    }
                },
                data: hlwyFlow,
                /*  [5, 3, 5, 6, 1, 5, 3, 5, 6, 4, 6, 4, 8, 3, 5, 6, 1, 5, 3, 7, 2, 5, 1, 4]*/

            },

        ]

    };




    /*重点业务资源分配*/
    var myChart7 = echarts.init($("#echart7")[0]);

    var res1 = [];    //横坐标数组（实际用来盛放X轴坐标值）
    var res2 = [];     //横坐标数组（实际用来盛放X轴坐标值）
    var res3 = [];    //横坐标数组（实际用来盛放X轴坐标值）

    option7 = {
        title: {    //图表标题
            text: '重点业务资源分配',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                fontSize:'210%',
                color:'#fffafa',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            /* y: 'top',*///垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
            y: 5,
        },
        backgroundColor: 'rgba(9,18,86,0.98)',
        toolbox: { //可视化的工具箱
            show: true,

            feature: {
                restore: { //重置
                    show: true
                },
                dataZoom: { //数据缩放视图
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                }
            }
        },
        tooltip: {
            /*注释掉会显示全部类别的值*/
            /*formatter: "{a}<br/>{b}<br/>{c}",
            trigger: 'item',*/
            trigger: 'axis',//坐标轴触发提示框，多用于柱状、折线图中
            show: true,
            axisPointer: {
                type: 'shadow',
                lineStyle: {
                    color: '#dddc6b'
                }
            }
        },

        legend: {
            top: '18%',
            left: '40%',
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize:'120%',  //更改坐标轴文字大小
            },
            data: ['主机数', 'CPU核数']

        },
        color: [
            '#4c00ff',    //温度曲线颜色
            '#ff2ae6',    //湿度曲线颜色
        ],
        //显示比例
        grid: {
            x: '7%',
            y: '30%',
            x2:'12%',
            y2: '3%',
            /* borderWidth: 0*/
            containLabel: true,//防止溢出
            width:'auto',//图例宽度
            height:'auto'//图例高度
        },
        xAxis: {
            name:"分配额",
            nameTextStyle :{
                fontSize: '150%'
            },
            type: 'value',
            axisLine: {
                lineStyle: {
                    color: '#675bba'
                }
            },
            axisLabel: {
                formatter: '{value}',
                textStyle: {
                    color: '#fefff9',
                    align: 'right',
                    fontSize:'120%'  //更改坐标轴文字大小
                }
            },
            splitLine: {
                show: false,
            },
            boundaryGap: [0, 0.01]
        },

//Y轴（这里我设置了两个Y轴，左右各一个）

        yAxis: {//第一个（左边）Y轴，yAxisIndex为0
            type: 'category',
            name: '重点业务',
            nameTextStyle :{
                fontSize: '150%'
            },
            /*max: 100,
            min: 0,*/
            scale: true,
            splitLine: {
                show: false,
            },
            axisLine: {
                lineStyle: {
                    color: '#675bba'
                }
            },
            axisLabel: {
                formatter: '{value}',
                textStyle: {
                    color: '#fefff9',
                    align: 'right',
                    fontSize:'120%' //更改坐标轴文字大小
                }
            },
            data: res1
        },
        series: [
            {
                name: '主机数',
                type: 'bar',
                data: res2
            },
            {
                name: 'CPU核数',
                type: 'bar',
                data: res3
            }
        ]
    };

    $.ajax({
        type: "get",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "zdywzy/selectzdywzysByDate",    //请求发送到dataActiont处
        data: {date: x},
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            debugger
            //把后台返回的数据给数组赋值
            $.each(result, function (key, v) {
                res1.push({
                    value: v.ywType,
                });
                res2.push({
                    value: v.pcNum,
                });
                res3.push({
                    value: v.cpuNum,
                });
            });
            // 使用刚指定的配置项和数据显示图表。
            myChart7.setOption(option7);
        },

        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart7.hideLoading();
        }

    });//end ajax


    window.addEventListener("resize", function () {
        myChart7.resize();
    });

    /*重点业务CPU使用率*/

    var myChart8 = echarts.init($("#echart8")[0]);

    option8 = {
        title: {    //图表标题
            text: '重点业务CPU使用率',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
                fontSize:'210%',
                color:'#fffafa',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x:'center',//水平安放位置，默认为'left'，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
            /* y: 'top',*///垂直安放位置，默认为top，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
            y: 5,
        },
        backgroundColor: 'rgba(9,18,86,0.98)',

        toolbox: { //可视化的工具箱

            show: true,
            feature: {
                restore: { //重置
                    show: true
                },
                dataZoom: { //数据缩放视图
                    show: true
                },
                saveAsImage: {//保存图片
                    show: true
                }
            }
        },
        //显示比例
        grid: {
            x: '5%',
            y: '30%',
            x2:'9%',
            y2: '3%',
            /* borderWidth: 0*/
            containLabel: true,//防止溢出
            width:'auto',//图例宽度
            height:'auto'//图例高度
        },

        color: ["#87cefa", "#ff7f50", "#32cd32", "#d178da", "#da06d6"],
        legend: {
            top: '18%',
            left: '20%',
            data: ['资源共享', '党政协同办公', '网站集约化', '服务一点通', '12345热线平台'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize:'120%',  //更改坐标轴文字大小
            }
        },
        calculable: false,

        tooltip: {

            trigger: 'axis',
            /*注释掉会显示全部类别的值*/
            /*formatter: "{a}<br/>{b}<br/>{c}",
               trigger: 'item',*/
            axisPointer: {
                type: 'shadow'
            }
        },
        yAxis: [    //Y轴（这里我设置了两个Y轴，左右各一个）
            {//第一个（左边）Y轴，yAxisIndex为0
                type: 'value',
                name: '使用率',
                nameTextStyle :{
                    fontSize: '150%'
                },
                /*max: 100,
                min: 0,*/
                scale: true,
                splitLine: {
                    show: false,
                },
                axisLine: {
                    lineStyle: {
                        color: '#675bba'
                    }
                },
                axisLabel: {
                    formatter: '{value}% ',
                    textStyle: {
                        color: '#fefff9',
                        align: 'right',
                        fontSize:'120%'  //更改坐标轴文字大小
                    }
                }
            }
        ],
        xAxis: [
            {
                name:"日期",
                nameTextStyle :{
                    fontSize: '150%'
                },
                type: 'category',
                data: resdates,
                /*['01', '02', '03', '04', '05', '06', '07', '08', '09', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24'],*/
                axisLine: {
                    lineStyle: {
                        color: '#675bba',
                        onZero: true
                    }
                },

                axisLabel: {
                    textStyle: {
                        fontSize:'120%',  //更改坐标轴文字大小
                        color: '#fff'
                    },
                    margin: 10,//刻度标签与轴线之间的距离。
                    interval: 1, //X轴的字与字见的距离
                    rotate: 0,//让X轴的字斜着放置。
                    //设置X轴的文字数组的排版
                    /*formatter: function (resdate) {
                        return resdate.split("").join("\n");
                    },*/
                },
                splitLine: {
                    "show": true,
                    lineStyle: {
                        width: 0,
                        type: 'solid'
                    }
                },
            }
        ],

        series: [
            {
                name: '资源共享',
                type: 'line',
                smooth: true,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            shadowColor: 'rgba(0,0,0,0.4)'
                        }
                    }
                },
                data: gongXiangCpu,

                /*[15, 0, 20, 45, 22.1, 25, 15, 0, 20, 45, 22.1, 25, 15, 0, 20, 45, 22.1, 25, 15, 0, 20, 45, 22.1, 25].reverse()*/
            },
            {
                name: '党政协同办公',
                type: 'line',
                smooth: true,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            shadowColor: 'rgba(0,0,0,0.4)'
                        }
                    }
                },
                data: xieTongCpu,
                /*[25, 10, 30, 55, 32.1, 35, 25, 10, 30, 55, 32.1, 35, 25, 10, 30, 55, 32.1, 35, 25, 10, 30, 55, 32.1, 35].reverse()*/
            },
            {
                name: '网站集约化',
                type: 'line',
                smooth: true,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            shadowColor: 'rgba(0,0,0,0.4)'
                        }
                    }
                },
                data: jiYueCpu,


                /*[35, 20, 40, 65, 42.1, 45, 35, 20, 40, 65, 42.1, 45, 35, 20, 40, 65, 42.1, 45, 35, 20, 40, 65, 42.1, 45].reverse()*/
            },
            {
                name: '服务一点通',
                type: 'line',
                smooth: true,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            shadowColor: 'rgba(0,0,0,0.4)'
                        }
                    }
                },
                data: yiDianCpu,

                /*[45, 30, 50, 75, 52.1, 55, 6, 45, 30, 50, 75, 52.1, 55, 6, 45, 30, 50, 75, 52.1, 55, 6, 45, 30, 50, 75, 52.1, 55, 6].reverse()*/
            },
            {
                name: '12345热线平台',
                type: 'line',
                smooth: true,
                itemStyle: {
                    normal: {
                        lineStyle: {
                            shadowColor: 'rgba(171,39,171,0.37)'
                        }
                    }
                },
                data: reXianCpu,
                /*[4, 37, 56, 70, 50, 51, 4, 37, 56, 70, 50, 51, 4, 37, 56, 70, 50, 51, 4, 37, 56, 70, 50, 51].reverse()*/
            }
        ]
    };

    $.ajax({
        type: "get",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "yueDatas/selectYuedatasByDate",    //请求发送到dataActiont处
        data: {date: x},
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            debugger
            //把后台返回的数据给数组赋值
            $.each(result, function (key, v) {

                resdates.push({
                    value: v.date,
                });
                zwyFlow.push({
                    value: v.zwyflow,
                });
                hlwyFlow.push({
                    value: v.hlwyflow,
                });
                junWen.push({
                    value: v.junwen,
                });
                junShi.push({
                    value: v.junshi,
                });
                ups.push({
                    value: v.ups,
                });
                dongLi.push({
                    value: v.dongli,
                });
                zDianLiang.push({
                    value: v.zdianliang,
                });
                cpuJun.push({
                    value: v.cpujun,
                });
                cpuFen.push({
                    value: v.cpufen,
                });
                zwyCpuNum.push({
                    value: v.zwycpunum,
                });
                zwyNeiCunNum.push({
                    value: v.zwyneicunnum,
                });
                zwyCiPanNum.push({
                    value: v.zwycipannum,
                });
                hlwyCpuNum.push({
                    value: v.hlwycpunum,
                });
                hlwyNeiCunNum.push({
                    value: v.hlwyneicunnum,
                });
                hlwyCiPanNum.push({
                    value: v.hlwycipannum,
                });
                gongXiangCpu.push({
                    value: v.gongxiangcpu,
                });
                xieTongCpu.push({
                    value: v.xietongcpu,
                });
                jiYueCpu.push({
                    value: v.jiyuecpu,
                });
                yiDianCpu.push({
                    value: v.yidiancpu,
                });
                reXianCpu.push({
                    value: v.rexiancpu,
                })
            });
            // 使用刚指定的配置项和数据显示图表。
            myChart1.setOption(option1);
            myChart2.setOption(option2);
            myChart3.setOption(option3);
            myChart5.setOption(option5);
            myChart6.setOption(option6);
            myChart8.setOption(option8);

        },

        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart1.hideLoading();
            myChart2.hideLoading();
            myChart3.hideLoading();
            myChart5.hideLoading();
            myChart6.hideLoading();
            myChart8.hideLoading();
        }

    });//end ajax

    window.addEventListener("resize", function () {
        myChart1.resize();
        myChart2.resize();
        myChart3.resize();
        myChart5.resize();
        myChart6.resize();
        myChart8.resize();
    });
}