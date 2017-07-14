package com.anjoyoe.Dao;

import java.util.ArrayList;

import com.anjoyoe.entities.Bookbean;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class BookDao extends BaseDao
{

	public BookDao(Context context) {
		super(context);
		
	}
	public void open() {
		super.open();
	}
	public void close() {
		super.close();
	}
	public void inserts(Bookbean bean){
		ContentValues values = new ContentValues();
		values.put("book_name", bean.bookName);
		values.put("book_path", bean.path);
		super.insert("book", values);
	}
	public ArrayList<Bookbean> selectAll(){
		Cursor cursor = super.query("book",new String[]{"book_name","book_path"});
		ArrayList<Bookbean> lists = new ArrayList<Bookbean>();
		while (cursor.moveToNext()){
			Bookbean bean = new Bookbean();
			bean.bookName=cursor.getString(cursor.getColumnIndex("book_name"));
			bean.path = cursor.getString(cursor.getColumnIndex("book_path"));
			lists.add(bean);
		}
		cursor.close();
		return lists;
		
	}
	//ȫ��ɾ���¼�
	public void deleteAll(){
		super.delete("book", null, null);
	}
	//ɾ������
	public void deletes(String path) {
		
		super.delete("book","book_path = ?",new String[]{path});
	}
	public boolean exists( String path) {
		return super.exists("book", "book_path" , path);
	}
	

}
