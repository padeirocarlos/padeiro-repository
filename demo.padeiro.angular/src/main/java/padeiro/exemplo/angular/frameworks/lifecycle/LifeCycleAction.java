package padeiro.exemplo.angular.frameworks.lifecycle;


import padeiro.exemplo.angular.usercontext.IUserContext;

public class LifeCycleAction{

	public void lifeCycleOnPCreate (final LifeCycleEntity entity,final IUserContext userContext)
	{
		if((entity!=null) && !entity.isCreated() && (userContext!=null))
		{
			entity.setActivatedBy(userContext.getUserId());
			entity.setCreatedBy(userContext.getUserId());
		}
	}

	public void lifeCycleOnRemove (final LifeCycleEntity entity,final IUserContext userContext)
	{
		if((entity!=null) && entity.isCreated() && (userContext!=null))
		{
			entity.setUpdatedBy(userContext.getUserId());
		}
	}


	public void lifeCycleOnUpdate(final LifeCycleEntity entity,final IUserContext userContext)
	{
		if((entity!=null) && entity.isCreated() && (userContext!=null))
		{
			entity.setUpdatedBy(userContext.getUserId());
		}
	}
}
