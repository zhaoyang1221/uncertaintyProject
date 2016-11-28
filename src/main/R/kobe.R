Kobe <- read.csv("Kobe Bryant.csv")

myvars <- c("G", "MP", "FG", "FGA", "X3P", "X3PA", "FT", "FTA", "ORB", "DRB", "AST", "STL", "BLK", "TOV", "PF", "PTS")
Kobe <- Kobe[myvars]
sdOfKobe <- apply(Kobe, 2, sd)

uncertaintyFunc1 <- function(x){
  return(sum(x))
}

uncertaintyOfKobe <- uncertaintyFunc1(sdOfKobe)
