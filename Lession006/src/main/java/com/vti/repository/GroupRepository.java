package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository implements IGroupRepository{
    private HibernateUtils hibernateUtils;

    public GroupRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @Override
    public void addNewGroup(Group grp) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(grp);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Group> getListGroups() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Group> query = session.createQuery("FROM Group") ;
            return query.list();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
