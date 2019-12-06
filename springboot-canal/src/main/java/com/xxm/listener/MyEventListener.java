package com.xxm.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.*;

import java.util.List;

/**
 * 监听数据的变化
 *
 * @author Mr Liu
 * @version 1.0
 * @package com.xxm.listener *
 * @Date 2019-11-26
 * @since 1.0
 */
@CanalEventListener//标识该注解下的类 会监听数据的变化和处理相关的逻辑
public class MyEventListener {

    @InsertListenPoint//当数据库进行insert操作时候触发该方法的调用.
    public void onEvent(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //do something...
    }

    @UpdateListenPoint
    public void onEvent1(CanalEntry.RowData rowData) {

        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();//更新前的数据


        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();//更新后的数据

        for (CanalEntry.Column column : afterColumnsList) {
            System.out.println("列名:" + column.getName() + ";职位:" + column.getValue());
        }

    }

    @DeleteListenPoint
    public void onEvent3(CanalEntry.EventType eventType) {
        //do something...
    }

    //自定义 监听哪个目的地  schema 指定具体的数据库实例名  table 监听的表  eventType 当发送的事件类型
    @ListenPoint(destination = "example", schema = "canal-test", table = {"t_user", "test_table"}, eventType = CanalEntry.EventType.UPDATE)
    public void onEvent4(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //do something...
    }
}
