package com.widget.time;

import java.util.Calendar;

import scl.leo.library.selectTime.*;
import com.widget.tools.WheelMain;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends Activity {
	WheelMain wheelMain;
	EditText txttime;

	Button btnselecttime1, btnselecttime2, btnselecttime3;

	int year, month, day, hour, min;

	LayoutInflater inflater;

	private PopupWindow mPopupWindowDialog;
	private Button determine;
	private Button cacel;

	View view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViews();

		Calendar calendar = Calendar.getInstance();

		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		min = calendar.get(Calendar.MINUTE);

		setListener();
	}

	private void findViews() {
		txttime = (EditText) findViewById(R.id.txttime);
		btnselecttime1 = (Button) findViewById(R.id.button1);
		btnselecttime2 = (Button) findViewById(R.id.button2);
		btnselecttime3 = (Button) findViewById(R.id.button3);

		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	private void setListener() {
		btnselecttime1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				view = inflater.inflate(R.layout.pop_timer, null);
				setPopupWindowDialog();

				ScreenInfo screenInfo = new ScreenInfo(MainActivity.this);
				wheelMain = new WheelMain(view, 0);
				wheelMain.screenheight = screenInfo.getHeight();
				wheelMain.initDateTimePicker(year, month, day, hour, min);

				if (mPopupWindowDialog != null) {
					mPopupWindowDialog.showAtLocation(
							findViewById(R.id.button3), Gravity.BOTTOM
									| Gravity.CENTER_HORIZONTAL, 0, 0);
				}

				bottomBtn();
			}
		});

		btnselecttime2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				view = inflater.inflate(R.layout.pop_timer, null);
				setPopupWindowDialog();

				ScreenInfo screenInfo = new ScreenInfo(MainActivity.this);
				wheelMain = new WheelMain(view, 1);
				wheelMain.screenheight = screenInfo.getHeight();
				wheelMain.initDateTimePicker(year, month, day, hour, min);

				if (mPopupWindowDialog != null) {
					mPopupWindowDialog.showAtLocation(
							findViewById(R.id.button3), Gravity.BOTTOM
									| Gravity.CENTER_HORIZONTAL, 0, 0);
				}

				bottomBtn();
			}
		});

		btnselecttime3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				view = inflater.inflate(R.layout.pop_timer, null);
				setPopupWindowDialog();

				ScreenInfo screenInfo = new ScreenInfo(MainActivity.this);
				wheelMain = new WheelMain(view, 2);
				wheelMain.screenheight = screenInfo.getHeight();
				wheelMain.initDateTimePicker(year, month, day, hour, min);

				if (mPopupWindowDialog != null) {
					mPopupWindowDialog.showAtLocation(
							findViewById(R.id.button3), Gravity.BOTTOM
									| Gravity.CENTER_HORIZONTAL, 0, 0);
				}

				bottomBtn();
			}
		});

	}

	protected void setPopupWindowDialog() {
		determine = (Button) view.findViewById(R.id.textview_dialog_album);
		cacel = (Button) view.findViewById(R.id.textview_dialog_cancel);

		mPopupWindowDialog = new PopupWindow(view, LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT, true);

		mPopupWindowDialog.setBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#b0000000")));
		mPopupWindowDialog.showAtLocation(view, Gravity.BOTTOM, 0, 0);
		mPopupWindowDialog.setAnimationStyle(R.style.app_pop);
		mPopupWindowDialog.setOutsideTouchable(true);
		mPopupWindowDialog.setFocusable(true);
		mPopupWindowDialog.update();
	}

	protected void bottomBtn() {
		determine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				txttime.setText(wheelMain.getTime());
				if (mPopupWindowDialog != null
						&& mPopupWindowDialog.isShowing()) {
					mPopupWindowDialog.dismiss();
				}
			}
		});

		cacel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (mPopupWindowDialog != null
						&& mPopupWindowDialog.isShowing()) {
					mPopupWindowDialog.dismiss();
				}
			}
		});
	}

}