## 后台开发遇到的问题

### String类型json数据转json

    JSONObject  json = JSONObject.fromObject(data);
    注意：要导入完整的jar包，有6个

### 使用数组拼装sql语句时，数据加 ‘’，切不能有[];

    去除[],的方法：
    String s = list.toString().substring(1,list.toString().length()-1);

    加引号的方法：
    list.add("'" + json.getString("username") + "'");

### jersey开发接口跨域解决方法

    @GET
    @Path("/document/{name}/{id}")
    @Produces("text/plain;charset=gbk")
    //@Produces({MediaType.TEXT_PLAIN_TYPE})
    @Consumes("application/x-www-form-urlencoded") //很重要
    public String  getContent(@PathParam("name") String name, @PathParam("id") int id) {
    select select = new select();
    ArrayList<document> list = select.getContent(name, id);
    //System.out.println(name + id);
    return ""+ list +"";
    }

    @POST
  	@Path("/studentMessage")
  	@Produces("text/plain;charset=gbk")
  	//@Produces({MediaType.APPLICATION_JSON})
  	@Consumes("application/x-www-form-urlencoded")
      public String postStudentMessage(String data) {
          System.out.println(data);
          updata student = new updata();
          student.getStudentAllMessage(data);
          //student.getStudentAllMessage(data);
          return "123";
      }

    相应的前段代码：
    $http({
                method: "post",
                url: url,
                data: {
                    id:"",
                    username:"para2",
                },
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            }).success(function (data) {
                alert(data);
            }).error(function (data) {
            });

### 删除数据库自增长id
    truncate table 你的表名 //这样不但将数据全部删除，而且重新定位自增的字段
