#例4-6：append.sed演示sed追加文本的用法
#!/bin/sed -f
/file:/a\                      #a\表示此处换行添加文本

#所添加的文本内容
We append a new line.\         #“\”符号表示换行
We append another line.     

