package com.liebe;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 生成订单编号
 * 
 * @desription
 * @author chenKun
 * @createtime 2016年5月5日 下午10:12:14
 */
public class OrderIdGenerateUtil {
	/*********************************************************************
	 * 产生一个唯一ID值
	 * 
	 * @return
	 ********************************************************************/
	/**
	 * 起始值
	 */
	private static long startVaue = 0;
	/**
	 * 随机数
	 */
	private static int random = (int) (Math.random() * 1000 + 1);
//	/**
//	 * 系统标示,信贷工厂-人工评估
//	 */
//	public final static int FILENO= 1;
//
//	/**
//	 *
//	 */
//	public final static int ORDERNO = 2;

	private static SimpleDateFormat oFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static DecimalFormat format = new DecimalFormat("000");

	/**
	 * 生成唯一订单编号
	 * 
	 * @desription 格式:X-XXX-XXXXXXXXXXXXXXXXX-XXX
	 * @desription 格式:系统标识-1000以内随机数-时间-计数
	 * @params
	 * @return
	 * @author chenKun
	 * @createtime 2016年5月5日 下午10:28:52
	 */
	public static synchronized String getOrderId(int systemType) {
		startVaue++;
		startVaue = startVaue % 1000;
		String sStartVaue = format.format(startVaue);
		String sDate = oFormat.format(new Date());
//		+ format.format(random)
		return systemType  + sDate + sStartVaue;
	}

//	public static String orderIdGenerate(String busType){
//
//		String currDate = DateUtil.getStringDate(DateUtil.YYYYMMDDHHMMSSsss);
//
//		return busType + currDate + format.format(Math.random() * 1000);
//	}
	
	/**
	 * 合同ID生成
	 * @param
	 * @return
	 */
//	public static String contractIdGenerate(String optor,String barCode){
//		return PinYinUtil.cn2py(optor).substring(0,4)+barCode;
//	}
	public static void main(String[] args) {
//		String orderId = getOrderId(2);
//		System.out.println(orderId);
		Set<String> set = new HashSet<>();
		for(int i=0; i<10000 ;i++){
			set.add(getOrderId(2));
//			set.add(contractIdGenerate("大大",getOrderId(2)));
//			System.out.println(getOrderId(2));
		}
		for (String str : set) {
			System.out.println(str);
		}
		System.out.println(set.size());
//		//	1.迭代遍历：
//		Set<String> set = new HashSet<String>();
//		java.util.Iterator<String> it = set.iterator();
//		while (it.hasNext()) {
//			String str = it.next();
//			System.out.println(str);
//		}
//		//2.for循环遍历：
//		for (String str : set) {
//			System.out.println(str);
//		}
	}




//	public static void main(String[] args) {
//		System.err.println(getOrderId(CF_MAN_EVALUATION));
//		System.err.println(getOrderId(CF_MAN_EVALUATION));
//		System.err.println(getOrderId(CF_MAN_EVALUATION));
//		System.err.println(getOrderId(CF_MAN_EVALUATION));
//		System.err.println(getOrderId(CF_MAN_EVALUATION));
//		System.err.println(getOrderId(CF_MAN_EVALUATION));
//
//		Map<String, Object> map = new HashMap<>();
//
//		int count = 0;
//		for(int i = 0; i < 1000; i++){
//
//			String id = OrderIdGenerateUtil.orderIdGenerate("10");
//			//System.out.println(id);
//
//			if(map.containsKey(id)){
//				count++;
//			}else{
//				map.put(id,new Object());
//			}
//
//
//		}
//
//		System.out.println(count);
//	}
}
