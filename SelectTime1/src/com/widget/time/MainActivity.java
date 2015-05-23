package com.widget.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.widget.time.tools.ScreenInfo;
import com.widget.time.tools.WheelMain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	WheelMain wheelMain;
	EditText txttime;

	Button btnselecttime1, btnselecttime2, btnselecttime3;

	int year, month, day, hour, min;

	LayoutInflater inflater;

	private static final int YYYYMMDD_HHMM = 0;
	private static final int YYYYMMDD = 1;
	private static final int YYYY = 2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		txttime = (EditText) findViewById(R.id.txttime);
		btnselecttime1 = (Button) findViewById(R.id.button1);
		btnselecttime2 = (Button) findViewById(R.id.button2);
		btnselecttime3 = (Button) findViewById(R.id.button3);

		String yyyy = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		yyyy = formatter.format(curDate);

		Log.e("-------------", yyyy);

		Calendar calendar = Calendar.getInstance();

		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		min = calendar.get(Calendar.MINUTE);

		inflater = LayoutInflater.from(MainActivity.this);

		btnselecttime1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final View timepickerview = inflater.inflate(
						R.layout.timepicker, null);
				ScreenInfo screenInfo = new ScreenInfo(MainActivity.this);

				wheelMain = new WheelMain(timepickerview, YYYYMMDD_HHMM);
				wheelMain.screenheight = screenInfo.getHeight();
				wheelMain.initDateTimePicker(year, month, day, hour, min);

				new AlertDialog.Builder(MainActivity.this)
						.setTitle("选择时间")
						.setView(timepickerview)
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										txttime.setText(wheelMain.getTime());
									}
								}).setNegativeButton("取消", null).show();

			}
		});

		btnselecttime2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				LayoutInflater inflater = LayoutInflater
						.from(MainActivity.this);
				final View timepickerview = inflater.inflate(
						R.layout.timepicker, null);
				ScreenInfo screenInfo = new ScreenInfo(MainActivity.this);

				wheelMain = new WheelMain(timepickerview, YYYYMMDD);
				wheelMain.screenheight = screenInfo.getHeight();
				wheelMain.initDateTimePicker(year, month, day, hour, min);

				new AlertDialog.Builder(MainActivity.this)
						.setTitle("选择日期")
						.setView(timepickerview)
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										txttime.setText(wheelMain.getTime());
									}
								}).setNegativeButton("取消", null).show();

			}
		});

		btnselecttime3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				LayoutInflater inflater = LayoutInflater
						.from(MainActivity.this);
				final View timepickerview = inflater.inflate(
						R.layout.timepicker, null);
				ScreenInfo screenInfo = new ScreenInfo(MainActivity.this);

				wheelMain = new WheelMain(timepickerview, YYYY);
				wheelMain.screenheight = screenInfo.getHeight();
				wheelMain.initDateTimePicker(year, month, day, hour, min);

				new AlertDialog.Builder(MainActivity.this)
						.setTitle("选择年份")
						.setView(timepickerview)
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										txttime.setText(wheelMain.getTime());
									}
								}).setNegativeButton("取消", null).show();

			}
		});
	}
}