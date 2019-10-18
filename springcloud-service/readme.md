数据缓存操作
参考https://blog.csdn.net/guokezhongdeyuzhou/article/details/79789629
在对应方法上加如下标签
读取缓存
    @Cacheable(value = "info", key = "'info'.concat(#id.toString())")
数据添加更新：
    @CachePut(value = "user", key = "'user'.concat(#user.id.toString())")
数据删除
    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")