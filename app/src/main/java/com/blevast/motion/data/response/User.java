package com.blevast.motion.data.response;

/**
 * A user data that is in github
 */
public class User {

    /***
     *
     *   "login": "Kalkidan",
     *   "id": 6887204,
     *   "node_id": "MDQ6VXNlcjY4ODcyMDQ=",
     *   "avatar_url": "https://avatars0.githubusercontent.com/u/6887204?v=4",
     *   "gravatar_id": "",
     *   "url": "https://api.github.com/users/Kalkidan",
     *   "html_url": "https://github.com/Kalkidan",
     *   "followers_url": "https://api.github.com/users/Kalkidan/followers",
     *   "following_url": "https://api.github.com/users/Kalkidan/following{/other_user}",
     *   "gists_url": "https://api.github.com/users/Kalkidan/gists{/gist_id}",
     *   "starred_url": "https://api.github.com/users/Kalkidan/starred{/owner}{/repo}",
     *   "subscriptions_url": "https://api.github.com/users/Kalkidan/subscriptions",
     *   "organizations_url": "https://api.github.com/users/Kalkidan/orgs",
     *   "repos_url": "https://api.github.com/users/Kalkidan/repos",
     *   "events_url": "https://api.github.com/users/Kalkidan/events{/privacy}",
     *   "received_events_url": "https://api.github.com/users/Kalkidan/received_events",
     *   "type": "User",
     *   "site_admin": false,
     *   "name": "Kalkidan Tadesse",
     *   "company": null,
     *   "blog": "",
     *   "location": null,
     *   "email": null,
     *   "hireable": null,
     *   "bio": null,
     *   "public_repos": 7,
     *   "public_gists": 0,
     *   "followers": 2,
     *   "following": 0,
     *   "created_at": "2014-03-07T21:00:14Z",
     *   "updated_at": "2018-08-02T15:50:59Z"
     *
     *
     *
     */

    private String  login;
    private String  id;
    private String  node_id;
    private String  avatar_url;
    private String  gravatar_id;
    private String  url;
    private String  html_url;
    private String  followers_url;
    private String  following_url;
    private String  gists_url;
    private String  starred_url;
    private String  subscriptions_url;
    private String  organizations_url;
    private String  repos_url;
    private String  events_url;
    private String  received_events_url;
    private String  type;
    private String  name;
    private String  created_at;
    private String  updated_at;
    private boolean site_admin;


    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getNodeId() {
        return node_id;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public String getGravatarId() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public String getFollowersUrl() {
        return followers_url;
    }

    public String getFollowingUrl() {
        return following_url;
    }

    public String getGistsUrl() {
        return gists_url;
    }

    public String getStarredUrl() {
        return starred_url;
    }

    public String getSubscriptionsUrl() {
        return subscriptions_url;
    }

    public String getOrganizationsUrl() {
        return organizations_url;
    }

    public String getReposUrl() {
        return repos_url;
    }

    public String getEventsUrl() {
        return events_url;
    }

    public String getReceivedEventsUrl() {
        return received_events_url;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public boolean isSiteAdmin() {
        return site_admin;
    }

    public User(String login,
                String id,
                String node_id,
                String avatar_url,
                String gravatar_id,
                String url,
                String html_url,
                String followers_url,
                String following_url,
                String gists_url,
                String starred_url,
                String subscriptions_url,
                String organizations_url,
                String repos_url,
                String events_url,
                String received_events_url,
                String type,
                String name,
                String created_at,
                String updated_at,
                boolean site_admin) {
        this.login = login;
        this.id = id;
        this.node_id = node_id;
        this.avatar_url = avatar_url;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.html_url = html_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.starred_url = starred_url;
        this.subscriptions_url = subscriptions_url;
        this.organizations_url = organizations_url;
        this.repos_url = repos_url;
        this.events_url = events_url;
        this.received_events_url = received_events_url;
        this.type = type;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.site_admin = site_admin;
    }
}
