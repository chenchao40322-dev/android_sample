package com.android.cc.cc_android.log;

import java.util.ArrayList;

import android.util.Log;

public class FSLogcat {
	public static final String TAG = "funshion";
	public static boolean DEBUG = true;
	public static boolean mDebugToFile = false;
	public static ArrayList<String> mFileTagFilters;

	public static void setDebugToFile() {
		if (DEBUG) {
			mDebugToFile = true;
			mFileTagFilters = new ArrayList<String>();
			FsDebugFileLog.init("/mnt/sdcard/", "fslogcat.txt");
		}
	}
	
	public static void registerFileTagFilter(String tag) {
		if (DEBUG && mDebugToFile && mFileTagFilters != null) {
			mFileTagFilters.add(tag);
		}
	}
	
	public static void i(String msg) {
		if (DEBUG) {
			Log.i(TAG, wrapMsg(msg));
			if (isDebugToFile(null)) {
				FsDebugFileLog.b("I, " + wrapMsg(msg));
			}
		}
	}

	public static void i(String tag, String msg) {
		if (DEBUG) {
			Log.i(tag, wrapMsg(msg));
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("I, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg));
			}
		}
	
	}

	public static void i(String tag, String msg, Throwable tr) {
		if (DEBUG) {
			Log.i(tag, wrapMsg(msg), tr);
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("I, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg) + FsDebugFileLog.LOG_SPLITER + tr.toString());
			}
		}	
	}
	
	public static void d(String msg) {
		if (DEBUG) {
			Log.d(TAG, wrapMsg(msg));
			if (isDebugToFile(null)) {
				FsDebugFileLog.b("D, " + wrapMsg(msg));
			}
		}
	}

	public static void d(String tag, String msg) {
		if (DEBUG) {
			Log.d(tag, wrapMsg(msg));
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("D, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg));
			}
		}
	
	}

	public static void d(String tag, String msg, Throwable tr) {
		if (DEBUG) {
			Log.d(tag, wrapMsg(msg), tr);
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("D, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg) + FsDebugFileLog.LOG_SPLITER + tr.toString());
			}
		}	
	}

	public static void v(String msg) {
		if (DEBUG) {
			Log.v(TAG, wrapMsg(msg));
			if (isDebugToFile(null)) {
				FsDebugFileLog.b("V, " + wrapMsg(msg));
			}
		}
	}

	public static void v(String tag, String msg) {
		if (DEBUG) {
			Log.v(tag, wrapMsg(msg));
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("V, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg));
			}
		}
	}
	
	public static void v(String tag, String msg, Throwable tr) {
		if (DEBUG) {
			Log.v(tag, wrapMsg(msg), tr);
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("V, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg) + FsDebugFileLog.LOG_SPLITER + tr.toString());
			}
		}	
	}

	public static void e(String msg) {
		if (DEBUG) {
			Log.e(TAG, wrapMsg(msg));
			if (isDebugToFile(null)) {
				FsDebugFileLog.b("E, " + wrapMsg(msg));
			}
		}
	}

	public static void e(String tag, String msg) {
		if (DEBUG) {
			Log.e(tag, wrapMsg(msg));
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("E, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg));
			}
		}
	
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (DEBUG) {
			Log.e(tag, wrapMsg(msg), tr);
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("E, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg) + FsDebugFileLog.LOG_SPLITER + tr.toString());
			}
		}
	}
	
	
	public static void w(String msg) {
        if (DEBUG) {
            Log.w(TAG, wrapMsg(msg));
			if (isDebugToFile(null)) {
				FsDebugFileLog.b("W, " + wrapMsg(msg));
			}
        }
    }
	
	public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, wrapMsg(msg));
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("W, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg));
			}
        }
    }
	
	public static void w(String tag, String msg, Throwable tr) {
		if (DEBUG) {
			Log.w(tag, wrapMsg(msg), tr);
			if (isDebugToFile(tag)) {
				FsDebugFileLog.b("W, " + tag + FsDebugFileLog.LOG_SPLITER + wrapMsg(msg) + FsDebugFileLog.LOG_SPLITER + tr.toString());
			}
		}	
	}
	
	public static void Logger(String msg) {
		if (DEBUG) {
			Log.e(TAG, wrapMsg(msg));
		}
	}
	
	private static String wrapMsg(String msg){
		if(msg == null)
			return "null";
		return msg;
	}
	
	private static boolean isDebugToFile(String tag) {
		if (mDebugToFile && mFileTagFilters != null) {
			if (mFileTagFilters.isEmpty()) {
				return true;
			} else {
				if (tag == null) {
					return false;
				} else {
					for (int i = 0; i < mFileTagFilters.size(); i++) {
						if (mFileTagFilters.get(i).equals(tag)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void test() {
		FSLogcat.setDebugToFile();
		FSLogcat.registerFileTagFilter("test");
		FSLogcat.i("test");
		FSLogcat.i("test", "test");
		FSLogcat.i("testt", "test");
	}
}
