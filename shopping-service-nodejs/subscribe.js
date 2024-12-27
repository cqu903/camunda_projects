import { Client, logger, Variables } from 'camunda-external-task-client-js';

// 配置客户端
const config = {
    baseUrl: 'http://localhost:8080/engine-rest',
    use: logger,
    asyncResponseTimeout: 10000
};

// 创建客户端实例
const client = new Client(config);

// 订阅外部任务处理函数
client.subscribe('pay', { processDefinitionKey: 'Process_shopping' },
    async function ({ task, taskService }) {
        // 获取流程变量
        const size = task.variables.get('size');
        const count = task.variables.get('count');

        console.log(`顾客下单尺寸：${size} ,数量：${count}`);
        const processVariables = new Variables().set("toWhere", "中国上海");
        try {
            await taskService.complete(task, processVariables);
            console.log('支付任务处理完成');
        } catch (error) {
            console.error('处理支付任务时发生错误:', error);
        }
    }
);

console.log('外部任务客户端已启动，正在监听支付任务...');
