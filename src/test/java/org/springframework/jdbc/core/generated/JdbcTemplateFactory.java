package org.springframework.jdbc.core.generated;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import org.springframework.dao.DataAccessException;
import com.advancedpwr.record.mock.MockFactory;

public class JdbcTemplateFactory extends MockFactory
{

	protected JdbcTemplate jdbctemplate;

	public JdbcTemplate buildJdbcTemplate() throws DataAccessException
	{
		if ( jdbctemplate != null ) 
		{
			return jdbctemplate;
		}
		jdbctemplate = createStrictMock( JdbcTemplate.class );
		expect( jdbctemplate.queryForList( "SELECT COL FROM TEST",java.lang.String.class ) ).andReturn( buildArrayList_1_1() );
		replay( jdbctemplate );
		return jdbctemplate;
	}

	protected ArrayList arraylist_1_1;

	protected ArrayList buildArrayList_1_1()
	{
		if ( arraylist_1_1 != null ) 
		{
			return arraylist_1_1;
		}
		arraylist_1_1 = createStrictMock( ArrayList.class );
		expect( arraylist_1_1.size() ).andReturn( new Integer( 4 ) );
		expect( arraylist_1_1.get( new Integer( 0 ) ) ).andReturn( "Hello" );
		expect( arraylist_1_1.get( new Integer( 1 ) ) ).andReturn( " " );
		expect( arraylist_1_1.get( new Integer( 2 ) ) ).andReturn( "World" );
		expect( arraylist_1_1.get( new Integer( 3 ) ) ).andReturn( "!" );
		replay( arraylist_1_1 );
		return arraylist_1_1;
	}
}
