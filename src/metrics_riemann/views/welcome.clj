(ns metrics-riemann.views.welcome
  (:require [metrics-riemann.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage defpartial render]]
        [hiccup.core :only [html]]
        [hiccup.form :as form])
  (import com.yammer.metrics.Metrics 
          com.yammer.metrics.core.MetricName))


(defpage "/my-page" []
  (common/site-layout
   [:h1 "This is my first page!"]
   [:p "Hope you like it!"]))

(defpartial user-fields [{:keys [firstname lastname]}]
  (form/label "firstname" "First name: ")
  (form/text-field "firstname" firstname)
  (form/label "lastname" "Last name: ")
  (form/text-field "lastname" lastname))

(defpage "/user/add" {:as user}
  (common/site-layout
    (form-to [:post "/user/add"]
            (user-fields user)
            (submit-button "Add user"))))

(defn valid? [{:keys [firstname lastname]}]
  true)

(defpage [:post "/user/add"] {:as user}
  (if (valid? user)
    (do
      (inc-counter)
      (common/site-layout
       [:p "User added, bitches!"]))    
    (render "/user/add" user)))

(defn inc-counter
  []
  (let [counter (Metrics/newCounter (new MetricName "test" "counter" "Test Counter"))]
    (do
      (println counter)
      (.inc counter))))