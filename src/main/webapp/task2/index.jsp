<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<!DOCTYPE html>
<html>
<head>
    <title>Music Shop</title>
    <meta charset=utf-8>
    <style>
    * {
      box-sizing: border-box;
    }
    #myTable {
      border-collapse: collapse;
      width: 20%;
      border: 1px solid #ddd;
      font-size: 18px;
    }

    #myTable th, #myTable td {
      text-align: left;
      padding: 12px;
    }

    #myTable tr {
      border-bottom: 1px solid #FF8C00;
    }

    #myTable tr.header, #myTable tr:hover {
      background-color: #f1f1f1;
    }
    .round-button {
      display: block;
      width: 50px;
      height: 50px;
      line-height: 50px;
      border: 2px solid #f5f5f5;
      border-radius: 50%;
      color: #FF8C00;
      text-align: center;
      text-decoration: none;
      background: #FF8C00;
      box-shadow: 0 0 3px gray;
      font-size: 20px;
      font-weight: bold;
    }

    .round-button:hover {
      background: #FF8C00;
    }

    @import url('https://rsms.me/inter/inter.css');

    :root {
      --color-light: white;
      --color-dark: #212121;
      --color-signal: #FF8C00;

      --color-background: var(--color-light);
      --color-text: var(--color-dark);
      --color-accent: var(--color-signal);

      --size-bezel: .5rem;
      --size-radius: 4px;

      line-height: 1.4;

      font-family: 'Inter', sans-serif;
      font-size: calc(.6rem + .4vw);
      color: var(--color-text);
      background: var(--color-background);
      font-weight: 300;
      padding: 0 calc(var(--size-bezel) * 3);
    }

    h1, h2, h3 {
      font-weight: 900;
    }

    mark {
      background: var(--color-accent);
      color: var(--color-text);
      font-weight: bold;
      padding: 0 0.2em;
    }

    .card {
      background: var(--color-background);
      padding: calc(4 * var(--size-bezel));
      margin-top: calc(4 * var(--size-bezel));
      border-radius: var(--size-radius);
      border: 3px solid var(--color-shadow, currentColor);
      box-shadow: .5rem .5rem 0 var(--color-shadow, currentColor);

      &--inverted {
        --color-background: var(--color-dark);
        color: var(--color-light);
        --color-shadow: var(--color-accent);
      }

      &--accent {
        --color-background: var(--color-signal);
        --color-accent: var(--color-light);
        color: var(--color-dark);
      }

      *:first-child {
        margin-top: 0;
      }
    }


    .l-design-widht {
      max-width: 40rem;
      padding: 1rem;
    }

    .input {
      position: relative;

      &__label {
        position: absolute;
        left: 0;
        top: 0;
        padding: calc(var(--size-bezel) * 0.75) calc(var(--size-bezel) * .5);
        margin: calc(var(--size-bezel) * 0.75 + 3px) calc(var(--size-bezel) * .5);
        background: pink;
        white-space: nowrap;
        transform: translate(0, 0);
        transform-origin: 0 0;
        background: var(--color-background);
        transition: transform 120ms ease-in;
        font-weight: bold;
        line-height: 1.2;
      }
      &__field {
        box-sizing: border-box;
        display: block;
        width: 100%;
        border: 3px solid currentColor;
        padding: calc(var(--size-bezel) * 1.5) var(--size-bezel);
        color: currentColor;
        background: transparent;
        border-radius: var(--size-radius);

        &:focus,
        &:not(:placeholder-shown) {
          & + .input__label {
            transform: translate(.25rem, -65%) scale(.8);
            color: var(--color-accent);
          }
        }
      }
    }


    .button-group {
      margin-top: calc(var(--size-bezel) * 2.5);
    }

    button {
      color: currentColor;
      padding: var(--size-bezel) calc(var(--size-bezel) * 2);
      background: var(--color-accent);
      border: none;
      border-radius: var(--size-radius);
      font-weight: 900;

      &[type=reset]{
        background: var(--color-background);
        font-weight: 200;
      }
    }

    button + button {
      margin-left: calc(var(--size-bezel) * 2);
    }

    .icon {
      display: inline-block;
      width: 1em; height: 1em;
      margin-right: .5em;
    }
    .hidden {
      display: none;
    }
    .block-1 {position:fixed;left:0;top:0;width:50%;height:100%;overflow:auto;}
    .block-2 {position:fixed;right:0;top:0;width:50%;height:100%;overflow:auto;}
    </style>
</head>
<body>

<div class="block-1">
<form action="task2" method="get">
    <table id="myTable">
        <tr class="header">
            <th>idItems</th>
            <th>idCategory</th>
            <th>idProducer</th>
            <th>itemName</th>
        </tr>
        <c:forEach items="${requestScope.items}" var="item">
              <tr>
                  <td><c:out value="${item.idItems}"/></td>
                  <td><c:out value="${item.idCategory}"/></td>
                  <td><c:out value="${item.idProducer}"/></td>
                  <td><c:out value="${item.itemName}"/></td>
              </tr>
        </c:forEach>
    </table>
    <button>SELECT INFO ABOUT BOOKS</button>
</form>


<form action="task2" method="get">
    <table id="myTable">
        <tr class="header">
            <th>idProducer</th>
            <th>ProducerName</th>
            <th>ProducerCountry</th>
        </tr>
        <c:forEach items="${requestScope.producers}" var="producer">
              <tr>
                  <td><c:out value="${producer.idProducer}"/></td>
                  <td><c:out value="${producer.producerName}"/></td>
                  <td><c:out value="${producer.producerCountry}"/></td>
              </tr>
        </c:forEach>
    </table>
    <button>SELECT INFO ABOUT PRODUCERS</button>
</form>


<form action="task2" method="get">
    <table id="myTable">
        <tr class="header">
            <th>idItem</th>
            <th>countItem</th>
            <th>idCloset</th>
        </tr>
        <c:forEach items="${requestScope.stocks}" var="stock">
              <tr>
                  <td><c:out value="${stock.idItem}"/></td>
                  <td><c:out value="${stock.countItem}"/></td>
                  <td><c:out value="${stock.idCloset}"/></td>
              </tr>
        </c:forEach>
    </table>
    <button>SELECT INFO ABOUT STOCK</button>
</form>


<form action="task2" method="get">
        <table id="myTable">
            <tr class="header">
                <th>idCategory</th>
                <th>nameCategory</th>
            </tr>
            <c:forEach items="${requestScope.categories}" var="ctg">
                  <tr>
                      <td><c:out value="${ctg.idCategory}"/></td>
                      <td><c:out value="${ctg.nameCategory}"/></td>
                  </tr>
            </c:forEach>
        </table>
       <button>SELECT INFO ABOUT CATEGORIES</button>
</form>
</div class="block-1">

<div class="block-2">
    <article class="l-design-widht">
    <div class="card card--inverted">
    <form action="task2" method="post">
    <h2>Add music</h2>
        <input type="hidden" name="action" value="add">
        idItems: <input type="text" name="idItemsIN"><br>
        idCategory: <input type="text" name="idCategoryIN"><br>
        idProducer: <input type="text" name="idProducerIN"><br>
        itemName: <input type="text" name="itemNameIN"><br>
        <div class="button-group">
            <button>ADD ITEM</button>
        </div>
    </form>
    </div>
    </article>

    <article class="l-design-widht">
        <div class="card card--inverted">
        <form action="task2" method="post">
        <h2>Delete music</h2>
             <input type="hidden" name="action" value="delete">
             Item ID: <input type="text" name="itemID"><br>
            <div class="button-group">
                <button>DELETE ITEM</button>
            </div>
        </form>
        </div>
        </article>

    <article class="l-design-widht">
            <div class="card card--inverted">
            <form action="task2" method="post">
            <h2>Update music</h2>
                 <input type="hidden" name="action" value="update">
                    idItemsUP: <input type="text" name="idItemsUP"><br>
                         idCategoryUP: <input type="text" name="idCategoryUP"><br>
                         idProducerUP: <input type="text" name="idProducerUP"><br>
                         itemNameUP: <input type="text" name="itemNameUP"><br>
                <div class="button-group">
                    <button>UPDATE ITEM</button>
                </div>
            </form>
            </div>
            </article>


<article class="l-design-widht">
    <div class="card card--inverted">
    <form action="task2" method="post">
    <h2>Add stock</h2>
        <input type="hidden" name="action" value="addStock">
        idItem: <input type="text" name="idItem"><br>
        countItem: <input type="text" name="countItem"><br>
        idCloset: <input type="text" name="idCloset"><br>
        <div class="button-group">
            <button>ADD STOCK</button>
        </div>
    </form>
    </div>
    </article>

    <article class="l-design-widht">
        <div class="card card--inverted">
        <form action="task2" method="post">
        <h2>Delete stock</h2>
             <input type="hidden" name="action" value="deleteStock">
             IdCloset: <input type="text" name="IdClosetDEL"><br>
            <div class="button-group">
                <button>DELETE STOCK</button>
            </div>
        </form>
        </div>
        </article>


<article class="l-design-widht">
    <div class="card card--inverted">
    <form action="task2" method="post">
    <h2>Add producer</h2>
        <input type="hidden" name="action" value="addProducer">
        idProducer: <input type="text" name="idProducerIN"><br>
        producerName: <input type="text" name="producerNameIN"><br>
        producerCountry: <input type="text" name="producerCountryIN"><br>
        <div class="button-group">
            <button>ADD PRODUCER</button>
        </div>
    </form>
    </div>
    </article>

    <article class="l-design-widht">
        <div class="card card--inverted">
        <form action="task2" method="post">
        <h2>Delete producer</h2>
             <input type="hidden" name="action" value="deleteProducer">
             Producer ID: <input type="text" name="idProducerDEL"><br>
            <div class="button-group">
                <button>DELETE PRODUCER</button>
            </div>
        </form>
        </div>
        </article>


<article class="l-design-widht">
    <div class="card card--inverted">
    <form action="task2" method="post">
    <h2>Add category</h2>
        <input type="hidden" name="action" value="addCategory">
        idCategory: <input type="text" name="idCategoryIN"><br>
        nameCategory: <input type="text" name="nameCategoryIN"><br>
        <div class="button-group">
            <button>ADD CATEGORIY</button>
        </div>
    </form>
    </div>
    </article>

    <article class="l-design-widht">
        <div class="card card--inverted">
        <form action="task2" method="post">
        <h2>Delete category</h2>
             <input type="hidden" name="action" value="deleteCategory">
             Category ID: <input type="text" name="idCategoryDEL"><br>
            <div class="button-group">
                <button>DELETE CATEGORIY</button>
            </div>
        </form>
        </div>
        </article>
</div class="block-2">
</body>
</html>