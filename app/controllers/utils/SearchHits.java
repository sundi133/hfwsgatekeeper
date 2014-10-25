package controllers.utils;

import java.util.ArrayList;
import java.util.List;


public class SearchHits {
	int took;
	boolean timed_out;
	Shard _shards;
	Hits hits;

}

class Hits{
	int total;
	double max_score;
	SerachResult[] hits = new SerachResult[100] ;
}

class Shard{
	int total;
	int successful;
	int failed;
}

class SerachResult{
	
String _index;
String _type;
String _id;
String _score;
public Source _source;

public String get_index() {
	return _index;
}
public void set_index(String _index) {
	this._index = _index;
}
public String get_type() {
	return _type;
}
public void set_type(String _type) {
	this._type = _type;
}
public String get_id() {
	return _id;
}
public void set_id(String _id) {
	this._id = _id;
}
public String get_score() {
	return _score;
}
public void set_score(String _score) {
	this._score = _score;
}
public Source get_source() {
	return _source;
}
public void set_source(Source _source) {
	this._source = _source;
}

}

class Source{
	String name;
	String pin;
	String state;
	String district;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
}
