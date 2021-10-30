(ns blocks.components.editor-output)

(defn editor-output []
  [:div {:style {:width "400px"}}
   [:h1 "Data"]
   [:div#data]
   [:h1 "Visual"]
   [:div#visual
    {:style {:width "400px" :height "500px"}}]])