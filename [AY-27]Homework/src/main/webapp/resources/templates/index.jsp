<html>
<body>
<h3>Please, fill the form below: </h3>
<form action="/result" method="post">
    <p>First name: <input type="text" name="firstName" placeholder="First name"/></p>
    <p>Last Name: <input type="text" name="lastName" placeholder="Last name"/></p>
    <p>Middle name: <input type="text" name="middleName" placeholder="Middle name"/></p>
    <p>Date of birth: <input type="date" name="dateOfBirth"/></p>
    <p>Gender:
        <select name="gender" class="form-control">
            <option value="">Please, enter your gender</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>
    </p>
    <button type="submit">Submit</button>
    <hr>
</form>
</body>
</html>
