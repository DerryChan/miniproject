功能层面
User
# 测试并且返回json结构中result包含rtx
# login()

Room
# 获取转/求租房屋信息，可在内部添加过滤条件，默认按publishtime递减查找
# 必须指定subject的值为0还是1
# 过滤条件: deadline, money, location
测试
#getRoomList()
# 房源发布字段：roomurl, description, location, money, deadline
# 求租发布字段：description, location, money, deadline
# 测试
# addNewRoom()
# 用于个人信息页面展示
# getRoomListByRtx()

========================================
代码层面优化
异常处理，日志
add操作参数校验
登录添加session
用户密码加密存储
# 太复杂了 不用
# shiro

缓存

========================================
update
#Room表没有roomurl字段，这个字段表示房屋图片的url，最多允许有9张图片
#login()成功应该返回rtx

========================================
任务
跟终端确定交互方式
腾讯云环境配置，或许可以把本地文件打包成war格式上传

迁移腾讯云
云主机上环境搭建，tomcat+mysql
图片传输url，apache.fileupload

ref
多个参数get请求 https://blog.csdn.net/rainbow702/article/details/53768802
springdata GET/POSTurl格式 https://blog.csdn.net/u011517841/article/details/77750120