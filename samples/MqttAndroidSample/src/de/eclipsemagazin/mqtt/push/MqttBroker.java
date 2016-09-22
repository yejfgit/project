package de.eclipsemagazin.mqtt.push;

public class MqttBroker {  
//    private static final int SEND_NUMBER = 5;  
//    static TopicConnection  connection;
//    static TopicSession session;/* 
//    public static void main(String[] args) throws JMSException { 
//        // ConnectionFactory �����ӹ�����JMS ������������  
//        ConnectionFactory connectionFactory;  
//        // Connection ��JMS �ͻ��˵�JMS Provider ������  
//        Connection connection = null;  
//        // Session�� һ�����ͻ������Ϣ���߳�  
//        Session session;  
//        // Destination ����Ϣ��Ŀ�ĵ�;��Ϣ���͸�˭.  ActiveMQConnectionFactory
//        Destination destination;  
//        // MessageProducer����Ϣ������  
//        MessageProducer producer;  
//        // TextMessage message;  
//        // ����ConnectionFactoryʵ�����󣬴˴�����ActiveMq��ʵ��jar  
//        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, tcp://192.168.0.183:61616);  
//        try {  
//            // ����ӹ����õ����Ӷ���  
//            connection = connectionFactory.createConnection();  
//            // ����  
//            connection.start();  
// 
//            // ��ȡ��������  
//            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);  
//            // ��ȡsessionע�����ֵxingbo.xu-queue��һ����������queue��������ActiveMq��console����  
//            destination = session.createQueue(FirstQueue);  
//            // �õ���Ϣ�����ߡ������ߡ�  
//            producer = session.createProducer(destination);  
//            // ���ò��־û����˴�ѧϰ��ʵ�ʸ�����Ŀ����  
//            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
//            // ������Ϣ���˴�д������Ŀ���ǲ��������߷�����ȡ  
//            sendMessage(session, producer);  
//            session.commit();  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            try {  
//                if (null != connection)  
//                    connection.close();  
//            } catch (Throwable ignore) {  
//            }  
//        } 
// 
//        init();
//        sendMessage(client123456,11111111111111111111111111111111); 
//    }
// 
// 
// 
// 
//    private static  void init() throws JMSException {
//        // �������ӹ���
//                TopicConnectionFactory factory = new ActiveMQConnectionFactory(
//                        ActiveMQConnection.DEFAULT_USER,
//                        ActiveMQConnection.DEFAULT_PASSWORD, tcp://192.168.0.183:1883);
//                connection = factory.createTopicConnection();
//            // ��������
//            connection.start();
//        System.out.println(�����ɹ�);
//            // ����һ��session�Ự transacted
//        session = connection.createTopicSession(
//                Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//    }  
// 
// 
// 
// 
//    *//**
//     * �ر�connection��session
//     * 
//     * @throws Exception
//     *//*
//    private void close() throws Exception {
// 
//        // �ر��ͷ���Դ
//        if (session != null) {
//            session.close();
//            session = null;
//        }
//        if (connection != null) {
//            connection.close();
//            connection = null;
//        }
//        System.out.println(�Ͽ�����);
//    }
//    public static int sendMessage(  String DESTINATION,String message)throws Exception {  
//        for (int i = 1; i <= 1; i++) {  
//            TextMessage message = session.createTextMessage(ActiveMq ���͵���Ϣ + i);  
//            // ������Ϣ��Ŀ�ĵط�  
//            System.out.println(������Ϣ�� + ActiveMq ���͵���Ϣ + i);  
//            producer.send(message);  
//        }  
//        javax.jms.Topic topic;
//        try {
//            // ����һ����Ϣ����
//            topic = session.createTopic(DESTINATION);
//        } catch (Exception e) {
//            init();
//            topic = session.createTopic(DESTINATION);
//        }
// 
//        // ������Ϣ������
//javax.jms.TopicPublisher publisher =  session.createPublisher(topic);
// 
//        // ���ó־û�ģʽ
//        publisher.setDeliveryMode(DeliveryMode.PERSISTENT);
// 
// 
// 
// 
// 
//        // flag=0,��ʾ�ɹ�;flag=1,��ʾʧ��
//                int flag = 0;
// 
//                System.out.println(message);
//                TextMessage textMessage = session.createTextMessage(message);
// 
//                publisher.send(textMessage);
//                return flag;
//    }  */
// 
// 
//     private final static Log logger = LogFactory.getLog(MqttBroker.class);// ��־����  
//        // ���Ӳ���  
//        private final static String CONNECTION_STRING = tcp://192.168.0.183:1883;  
////      private final static String CONNECTION_STRING = tcp://192.168.0.183:1883;  
// 
//        private final static boolean CLEAN_START = true;  
//        private final static short KEEP_ALIVE = 30;// �ͺ����磬��������Ҫ��ʱ��ȡ���ݣ�����30s  
//        private final static String CLIENT_ID = master;// �ͻ��˱�ʶ  
//        private final static int[] QOS_VALUES = { 0, 0, 2, 0 };// ��Ӧ�������Ϣ����  
//        private final static String[] TOPICS = { Test/TestTopics/Topic1,  
//                Test/TestTopics/Topic2, Test/TestTopics/Topic3,  
//                client/keepalive };  
//        private static MqttBroker instance = new MqttBroker();  
// 
//        private MqttClient mqttClient;  
// 
//        /** 
//         * ����ʵ������ 
//         *  
//         * @return 
//         */ 
//        public static MqttBroker getInstance() {  
//            return instance;  
//        }  
// 
//        /** 
//         * �������ӷ��� 
//         */ 
//        private void connect() throws MqttException {  
//            logger.info(connect to mqtt broker.);  
//            System.out.println(connect to mqtt broker.);  
//            mqttClient = new MqttClient(CONNECTION_STRING);  
//            logger.info(***********register Simple Handler***********);  
//            System.out.println(***********register Simple Handler***********);  
//            SimpleCallbackHandler simpleCallbackHandler = new SimpleCallbackHandler();  
//            mqttClient.registerSimpleHandler(simpleCallbackHandler);// ע�������Ϣ����  
//            mqttClient.connect(CLIENT_ID, CLEAN_START, KEEP_ALIVE);  
//            logger.info(***********subscribe receiver topics***********);  
//            System.out.println(***********subscribe receiver topics***********);  
//            mqttClient.subscribe(TOPICS, QOS_VALUES);// ���Ľ�����  
// 
//            logger.info(***********CLIENT_ID: + CLIENT_ID);  
//            System.out.println(***********CLIENT_ID: + CLIENT_ID);  
//            /** 
//             * ��ɶ��ĺ󣬿���������������������ͨ����Ҳ���Է����Լ�����Ϣ 
//             */ 
//            mqttClient.publish(keepalive, keepalive.getBytes(), QOS_VALUES[0],  
//                    true);// ������������������ͨ��  
//        }  
// 
//        /** 
//         * ������Ϣ 
//         *  
//         * @param clientId   �ͻ������� ����id
//         * @param messageId 
//         */ 
//        public void sendMessage(String clientId, String message) {  
//            try {  
//                if (mqttClient == null || !mqttClient.isConnected()) {  
//                    connect();  
//                }  
//                System.out.println(send message to  + clientId + , message is   
//                        + message);  
//                logger.info(send message to  + clientId + , message is   
//                        + message);  
//                // �����Լ�����Ϣ  
//                mqttClient.publish(clientId, message.getBytes(),  
//                        0, false);  
//                /*mqttClient.publish(GMCC/tokudu/ + clientId, message.getBytes(),  
//                        0, false); */
//              System.out.println(  ##################### + CLIENT_ID);  
//            } catch (MqttException e) {  
//                logger.error(e.getCause());  
//                e.printStackTrace();  
//            }  
//        }  
// 
//        /** 
//         * �򵥻ص�����������server���յ���������Ϣ 
//         *  
//         * @author Join 
//         *  
//         */ 
//        class SimpleCallbackHandler implements MqttSimpleCallback {  
// 
//            /** 
//             * ���ͻ�����broker����Ͽ�ʱ���� �����ٴ˴������¶��� 
//             */ 
//            @Override 
//            public void connectionLost() throws Exception {  
//                // TODO Auto-generated method stub  
//                System.out.println(�ͻ�����broker�Ѿ��Ͽ�);  
//            }  
// 
//            /** ��broker��
//             * �ͻ��˶�����Ϣ�󣬸÷�������ص����մ�����Ϣ 
//             */ 
//            @Override 
//            public void publishArrived(String topicName, byte[] payload, int Qos,  
//                    boolean retained) throws Exception {  
//                // TODO Auto-generated method stub  
//                System.out.println(��������:  + topicName);  
//                System.out.println(��Ϣ����:  + new String(payload));  
//                System.out.println(��Ϣ����(0,1,2):  + Qos);  
//                System.out.println(�Ƿ���ʵʱ���͵���Ϣ(false=ʵʱ��true=�������ϱ����������Ϣ):   
//                        + retained);  
//            }  
// 
//        }  
// 
//        public static void main(String[] args) {  
//            String ss={ itle: ghjklffff,content:aaaaaaaaaaaaaaaaaaa,    ype:1};
//            new MqttBroker().sendMessage(Fangchao,ss.replace(\, ));  
//        }  //һ��Ҫ��tokudu/a06e51a5f424fb70 ��Ҫ��tokudu.aasdf �÷�б��  ��Ҫ�õ�
    } 