package com.sharebo.util;

import java.util.List;

import com.sharebo.entity.MatchLicensePlateInfo;

/**
 * 软识别
 * 
 * @author niewei
 *
 */
public class MatchLicensePlateUtil {
	// 通过一组车牌计算
	public static MatchLicensePlateInfo calculate(List<MatchLicensePlateInfo> matchLicensePlateInfos, String carNo) {
		MatchLicensePlateInfo resM = null;
		char[] ch = new char[carNo.length()];
		// 拼装 方式一
		for (int i = 0; i < carNo.length(); i++) {
			ch[i] = carNo.charAt(i);
		}
		// 方式二：
		// ch=carNo.toCharArray();
		// 遍历
		for (MatchLicensePlateInfo m : matchLicensePlateInfos) {
			try {
				int xs_ = 0;
				for (int i = 0; i < m.getCarNo().length(); i++) {
					if (ch[i] == m.getCarNo().charAt(i)) {
						xs_ += 1;
					}
				}
				if (resM == null) {
					resM = new MatchLicensePlateInfo(m.getOrderId(), m.getCarNo(), xs_);
				} else {
					if (resM.getSimilarity() < xs_) {
						resM = new MatchLicensePlateInfo(m.getOrderId(), m.getCarNo(), xs_);
					}
				}
			} catch (Exception e) {
				continue;
			}
		}
		if (resM != null && (resM.getSimilarity() >= carNo.length() - 2)) {// 找到最高匹配，并判断位数
			return resM;
		}
		return null;
	}
}
